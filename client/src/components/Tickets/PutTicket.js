import React, { useState, useContext, useEffect } from 'react';
import {
  Button,
  Form,
  Input,
  Segment,
  Label,
  TextArea,
  Select,
  Header,
} from 'semantic-ui-react';
import axiosWithAuth from '../../utils/axiosWithAuth';

export default function PutTicket({ ticket }) {
  const [editTicket, setEditTicket] = useState(ticket);
  const [isSubmitting, setIsSubmitting] = useState(false);

  //temp fix till we get the current ticket available in app-wide state
  // useEffect(() => {
  //     axiosWithAuth()
  //         .get(`/ticket/12`)
  //         .then(res => {
  //             setEditTicket(res.data)
  //         })
  //         .catch(err => {
  //             console.log("ERROR FETCHING SINGLE TICKET==>", err)
  //         })
  // }, [])

  const putTicketRequest = newTicket => {
    setIsSubmitting(true);
    axiosWithAuth()
      .put(`/company/4/ticket/${ticket.ticketid}`, newTicket)
      .then(res => {
        console.log('SUCCESS EDITING TICKET==>', res);
        setIsSubmitting(false);
      })
      .catch(err => {
        console.log('ERROR EDITING TICKET==>', err);
      });
  };

  const changeHandler = e => {
    const { name, value } = e.target;
    setEditTicket({ ...editTicket, [name]: value });
  };

  const statuses = [
    { key: 's', text: 'Not started', value: 'not started' },
    { key: 'p', text: 'In progress', value: 'in progress' },
    { key: 'c', text: 'Completed', value: 'completed' },
  ];

  return (
    <div className="ticket-form-container">
      <div className="ticket-header">
        <Header color="black" as="h2" icon="bug" content="Add a New Ticket" />
      </div>
      <Form
        className="ticket-form"
        onSubmit={() => putTicketRequest(editTicket)}
      >
        <Form.Field width="16">
          <label>Title</label>
          <input
            type="text"
            value={editTicket.title}
            placeholder="Title"
            name="title"
            onChange={changeHandler}
          />
        </Form.Field>
        <Form.Group>
          <Form.Field>
            <label>ErrorCode</label>
            <input
              type="text"
              value={editTicket.errorcode}
              placeholder="Error Code"
              name="errorCode"
              onChange={changeHandler}
            />
          </Form.Field>
          <Form.Field>
            <label>Error Category</label>
            <input
              type="text"
              value={editTicket.errorcategory}
              placeholder="Error Category"
              name="errorCategory"
              onChange={changeHandler}
            />
          </Form.Field>
          <Form.Field width="5">
            <label className="ticket-form-label">Status</label>
            <Select
              placeholder="Status of issue..."
              options={statuses}
              clearable
            />
          </Form.Field>
        </Form.Group>
        <Form.Field width="16">
          <label>Description</label>
          <TextArea
            focus
            className="ticket-description-input"
            value={editTicket.description}
            placeholder="Description"
            name="description"
            onChange={changeHandler}
          />
        </Form.Field>
        <Button>Submit</Button>
        {!isSubmitting ? (
          <Button className="ticket-form-button" color="teal" floated="right">
            Submit
          </Button>
        ) : (
          <Button
            className="ticket-form-button"
            basic
            inverted
            loading
            color="blue"
            floated="right"
          >
            Submit
          </Button>
        )}
      </Form>
    </div>
  );
}
