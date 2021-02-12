import React from 'react';
import { Container, Header, Icon, Divider, List } from 'semantic-ui-react';

export default function Ticket({ ticket }) {
  console.log(ticket)
  return (
    <>
      <div className="ticket-form-container">
        <Container fluid textAlign="center">
          <div className="ticket-header">
            <Header as="h4" icon>
              <Icon name="file alternate outline" />
              {ticket.title}
              {/* <p>Created By: {ticket.user}</p> */}
            </Header>
          </div>
          <List>
            {
              console.log(ticket)
            }
            <List.Item>ID: {ticket.ticketid}</List.Item>
            <List.Item>Status: {ticket.status}</List.Item>
            <List.Item>Error Code: {ticket.errorcode}</List.Item>
            <List.Item>Error Category{ticket.errorcategory}</List.Item>
            <List.Item>Description: {ticket.description}</List.Item>
            <List.Item>Notes: {ticket.notes}</List.Item>
          </List>
        </Container>
      </div>
    </>
  );
}

// <div key={ticket.ticket.ticketid + 'div'}>
//   <ul>
//     <li key={1 + parseInt(ticket.ticket.ticketid)}>
//       ID: {ticket.ticket.ticketid}
//     </li>
//     <li key={2 + parseInt(ticket.ticket.ticketid)}>
//       Created By: {ticket.ticket.user}
//     </li>
//     <li key={3 + parseInt(ticket.ticket.ticketid)}>
//       Title: {ticket.ticket.title}
//     </li>
//     <li key={4 + parseInt(ticket.ticket.ticketid)}>
//       Desc: {ticket.ticket.description}
//     </li>
//     <li key={5 + parseInt(ticket.ticket.ticketid)}>
//       Status: {ticket.ticket.status}
//     </li>
//     <li key={6 + parseInt(ticket.ticket.ticketid)}>
//       Error Code: {ticket.ticket.errorcode}
//     </li>
//     <li key={7 + ticket.ticket.ticketid}>
//       Error Category: {ticket.ticket.errorcategory}
//     </li>
//     <li key={8 + ticket.ticket.ticketid}>
//       Notes: {ticket.ticket.notes}
//     </li>
//   </ul>
// </div>
