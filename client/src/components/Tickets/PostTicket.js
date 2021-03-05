//Component for user to add a new ticket
import React, { useState, useContext } from 'react';
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
import { Formik } from 'formik';
import { postTicket } from '../../utils/otherAxiosCalls';

const initalFormVal = {
  user: {
    userid: 0,
  },
  title: '',
  description: '',
  status: '',
  errorcode: '',
  category: '',
  notes: '',
  severity: '',
};

export default function PostTicket() {
  const [newTicket, setNewTicket] = useState(initalFormVal);
  const [isSubmitting, setIsSubmitting] = useState(false);

  const postNewTicket = ticket => {
    console.log(ticket);
    setIsSubmitting(true);
    postTicket(
      {
        title: ticket.title,
        description: ticket.description,
        status: ticket.status,
        errorcode: ticket.errorcode,
        category: ticket.category,
        severity: ticket.severity,
      },
      4
    )
      .then(res => {
        console.log(res.data);
        setIsSubmitting(false);
      })
      .catch(err => {
        console.log(err);
      });
  };

  const changeHandler = e => {
    const { name, value } = e.target;
    setNewTicket({ ...newTicket, [name]: value });
  };

  const statuses = [
    { key: 's', text: 'Not started', value: 'Not Started' },
    { key: 'p', text: 'In progress', value: 'In Progress' },
    { key: 'c', text: 'Completed', value: 'Completed' },
  ];

  const categories = [{ key: 's', text: 'Testing', value: 'Testing' }];

  const severities = [
    { key: 's', text: 'No Big Deal', value: 'No Big Deal' },
    { key: 'p', text: 'Now Massa', value: 'Now Massa' },
    { key: 'c', text: 'I SAID NOW', value: 'I SAID NOW' },
  ];

  return (
    <div className="ticket-form-container">
      <div className="ticket-header">
        <Header color="black" as="h2" icon="bug" content="Add a New Ticket" />
      </div>
      <Form
        className="ticket-form"
        onSubmit={() => postNewTicket(newTicket)}
        size="medium"
      >
        <Form.Group>
          <Form.Field width="8">
            <label
              basic
              className="ticket-form-label"
              style={{ fontSize: '10px' }}
            >
              Title
            </label>
            <Input
              focus
              type="text"
              placeholder="Title"
              name="title"
              onChange={changeHandler}
            />
          </Form.Field>
          <Form.Field width="6">
            <label className="ticket-form-label">Error Code</label>
            <Input
              focus
              type="text"
              placeholder="Error code"
              name="errorCode"
              onChange={changeHandler}
            />
          </Form.Field>
        </Form.Group>
        <Form.Group>
          <Form.Field width="5">
            <label className="ticket-form-label">Status</label>
            <Select
              placeholder="Category of issue..."
              options={categories}
              onChange={changeHandler}
              clearable
            />
          </Form.Field>
          <Form.Field width="5">
            <label className="ticket-form-label">Status</label>
            <Select
              placeholder="Status of issue..."
              options={statuses}
              onChange={changeHandler}
              clearable
            />
          </Form.Field>
          <Form.Field width="5">
            <label className="ticket-form-label">Status</label>
            <Select
              placeholder="Severity of issue..."
              options={severities}
              onChange={changeHandler}
              clearable
            />
          </Form.Field>
        </Form.Group>
        <Form.Field width="16">
          <label className="ticket-form-label">Description</label>
          <TextArea
            focus
            className="ticket-description-input"
            placeholder="Description"
            name="description"
            onChange={changeHandler}
          />
        </Form.Field>
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
