import React, {useState, useEffect} from 'react';
import axios from 'axios';

export default function TestTicketBoard() {
    const [tickets, setTickets] = useState([]);
    const [completed, setCompleted] = useState([])
    const [notStarted, setNotStarted] = useState([])
    const [inProgress, setInProgress] = useState([])
    const [statuses, setStatuses] = useState([])

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

    // const useCreateStatusState = (status) => {
    //     const [statusState, setStatusState] = useState([])

    //     status["statusState"] = statusState
    //     status["setStatusState"] = setStatusState
    //     return status
    // }

    // const [testState, setTestState] = useCreateStatusState();

    return (
        <div style={{border:"2px solid red", display:"flex"}}>
            {
                statuses.map((status) => 
                {
                    return (
                        <div onDragOver={(e) => onDragOver(e)} onDrop={(e) => onDrop(e, status)}>
                            <h3>{status.statustype}</h3>
                            {
                                tickets.map((tkt) => {
                                    if(tkt.status.statustype === status.statustype)
                                    {
                                        return(
                                        <div draggable onDragStart={(e) => onDragStart(e, tkt.ticketid)}>
                                            <h4>{tkt.title}</h4>
                                        </div>
                                        )
                                    }
                                })
                            } 
                        </div>
                    )
                })
            }
            {/* <div onDragOver={(e) => onDragOver(e)} onDrop={(e) => onDrop(e, "Not started. Testing")}>
                <h3>NOT STARTED</h3>
                {
                    tickets.map((tkt) => {
                        if(tkt.status.statustype === "Not started. Testing")
                        {
                            return(
                            <div draggable onDragStart={(e) => onDragStart(e, tkt.ticketid)}>
                                <h4>{tkt.title}</h4>
                                <p>PLEASE WORK</p>
                            </div>
                            )
                        }
                    })
                } 
            </div>
            <div onDragOver={(e) => onDragOver(e)} onDrop={(e) => onDrop(e, "Completed. Testing")}>
                <h3>COMPLETED</h3>
                {
                    tickets.map((tkt) => {
                        if(tkt.status.statustype === "Completed. Testing")
                        {
                            return(
                            <div draggable onDragStart={(e) => onDragStart(e, tkt.ticketid)}>
                                <h4>{tkt.title}</h4>
                                <p>PLEASE WORK</p>
                            </div>
                            )
                        }
                    })
                }
            </div> */}
        </div>
        
    )
}
