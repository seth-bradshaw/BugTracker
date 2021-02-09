import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';
import { Container, Header } from 'semantic-ui-react';
import Ticket from './Tickets/Ticket';

export default function Dashboard() {
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);
  const tickets = useSelector((state) => state.tickets.tickets);
  const [getIsEditing, setIsEditing] = useState(false);

  const updateSection = () => {};

  useEffect(() => {
    dispatch(getCurrentUser());
  }, []);

  // useEffect(() => {
  //   axiosWithAuth()
  //     .get('/company/4/tickets')
  //     .then((res) => console.log(res))
  //     .catch((err) => console.log(err));
  // }, []);

  return (
    <>
      <Container textAlign="center">
        <div>Dashboard</div>
      </Container>
      {console.log(tickets)}
      {tickets.length > 0 &&
        tickets.map((ticket) => {
          return (
            <Ticket ticket={ticket} />
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
          );
        })}
    </>
  );
}
