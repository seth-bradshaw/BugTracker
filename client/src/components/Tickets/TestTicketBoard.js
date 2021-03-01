import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Header, Modal} from 'semantic-ui-react';
import SingleTicket from './SingleTicket';

export default function TestTicketBoard() {
    //I'm thinking we pass tickets through props so that this component can be used for every trello board
    const [tickets, setTickets] = useState([]);
    const [completed, setCompleted] = useState([])
    const [notStarted, setNotStarted] = useState([])
    const [inProgress, setInProgress] = useState([])
    const [statuses, setStatuses] = useState([])
    const [showTicketModal, setShowTicketModal] = useState(false)

    useEffect(() => {
        axios.get('http://localhost:2019/tickets/tickets')
        .then((res) => 
        {
            setTickets(res.data)
        })
        .catch((err) => {
            console.log(err)
        })

        axios.get('http://localhost:2019/statuses/statuses')
        .then((res) =>
        {
            setStatuses(res.data)
        })
        .catch((err) => 
        {
            console.log(err)
        })
    }, [])

    const onDragStart = (e, id) =>
    {
        e.dataTransfer.setData("id", id)
    }

    const onDragOver = (e) => 
    {
        e.preventDefault();
    }

    const onDrop = (e, status) =>
    {
        let id = e.dataTransfer.getData("id");

        let tasks = tickets.filter((tkt) => 
        {
            if(tkt.ticketid == id)
            {
                tkt.status.statustype = status.statustype
            }
            return tkt
        })

        
        if(status.statustype === "Not started")
        {
            setNotStarted({...notStarted, tasks})
        }
        if(status.statustype === "In progress")
        {
            setInProgress({...inProgress, tasks})
        }
        if(status.statustype === "Completed")
        {
            setCompleted({...completed, tasks})
        }
    }

    const popSingleTicket = (e, tkt) => 
    {
        e.preventDefault()
        return <SingleTicket ticket={tkt} />
    }

    // const useCreateStatusState = (status) => {
    //     const [statusState, setStatusState] = useState([])

    //     status["statusState"] = statusState
    //     status["setStatusState"] = setStatusState
    //     return status
    // }

    return (
        <div style={{border:"2px solid red", display:"flex", justifyContent:"space-evenly"}}>
            {
                statuses.map((status) => 
                {
                    return (
                        <div onDragOver={(e) => onDragOver(e)} onDrop={(e) => onDrop(e, status)} style={{border:"2px solid green"}}>
                            <h3>{status.statustype}</h3>
                            {
                                tickets.map((tkt) => {
                                    if(tkt.status.statustype === status.statustype)
                                    {
                                        return(
                                        <Modal
                                            onClose={() => setShowTicketModal(false)}
                                            onOpen={() => setShowTicketModal(true)}
                                            trigger={
                                                <div draggable onDragStart={(e) => onDragStart(e, tkt.ticketid)} onClick={(e) => popSingleTicket(e, tkt)}>
                                                    <h4>{tkt.title}</h4>
                                                </div>
                                            }
                                        >
                                            <Modal.Header>{tkt.title}</Modal.Header>
                                            <Modal.Content>
                                                <Modal.Description>
                                                    <h4>Category:</h4>
                                                    <p>{tkt.category.categorytype}</p>
                                                    <h4>Error Code:</h4>
                                                    <p>{tkt.errorcode}</p>
                                                    <h4>Severity:</h4>
                                                    <p>{tkt.severity}</p>
                                                    <h4>Description:</h4>
                                                    <p>{tkt.description}</p>
                                                </Modal.Description>
                                            </Modal.Content>
                                        </Modal>
                                        )
                                    }
                                })
                            } 
                        </div>
                    )
                })
            }
        </div>
    )
}
