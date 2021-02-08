//Component for user to add a new ticket
import React, {useState, useContext} from 'react';
import { Button, Form, Input, Segment, Label, TextArea, Select, Header} from 'semantic-ui-react';
import {Formik} from 'formik';
import {postTicket} from '../../utils/otherAxiosCalls';

const initalFormVal = {
    user: {
        userid: 0
    },
    title: "",
    description: "",
    status: "incomplete",
    errorCode: "",
    errorCategory: "",
    notes: ""
}

export default function PostTicket() {
    const [newTicket, setNewTicket] = useState(initalFormVal);
    const [isSubmitting, setIsSubmitting] = useState(false);

    const postNewTicket = (ticket) => {
        setIsSubmitting(true)
        postTicket({ title: ticket.title, description: ticket.description, status: ticket.status, errorCode: ticket.errorCode, errorCategory: ticket.errorCategory}, 4)
            .then(res => {
                console.log(res.data)
                setIsSubmitting(false)
            })
            .catch(err => {
                console.log(err)
            })
    }

    const changeHandler = (e) => {
        const {name, value} = e.target;
        setNewTicket({...newTicket, [name]:value})
    }

    const statuses = [
        {key: "s", text:"Not started", value: "not started"},
        {key: "p", text:"In progress", value: "in progress"},
        {key: "c", text:"Completed", value: "completed"},
    ]

    return (

        <div className="ticket-form-container">
            <div className="ticket-header">
            <Header color="black" as='h2' icon='bug' content='Add a New Ticket'/>
            </div>
            <Form className="ticket-form" onSubmit={() => postNewTicket(newTicket)} size="medium">
                <Form.Field width="16">
                    <label  basic className="ticket-form-label" >Title</label>
                    <Input  focus type="text" placeholder="Title" name="title" onChange={changeHandler}/>
                </Form.Field>
                <Form.Group>
                    <Form.Field width="6">
                        <label className="ticket-form-label">Error Code</label>
                        <Input focus type="text" placeholder="Error code" name="errorCode" onChange={changeHandler}/>
                    </Form.Field>
                    <Form.Field width="5">
                        <label className="ticket-form-label">Error Category</label>
                        <Input focus type="text" placeholder="Error category" name="errorCategory" onChange={changeHandler}/>
                    </Form.Field>
                    <Form.Field width="5">
                        <label className="ticket-form-label">Status</label>
                        <Select placeholder="Status of issue..." options={statuses} clearable/>
                    </Form.Field>
                </Form.Group>
                <Form.Field width="16">
                    <label className="ticket-form-label">Description</label>
                    <TextArea focus className="ticket-description-input" placeholder="Description" name="description" onChange={changeHandler}/>
                </Form.Field>
                {
                    !isSubmitting ?
                    <Button className="ticket-form-button" color="teal"floated="right">Submit</Button>
                    :
                    <Button className="ticket-form-button" basic inverted loading color="blue" floated="right">Submit</Button>
                }
            </Form>
        </div>
    )
}
