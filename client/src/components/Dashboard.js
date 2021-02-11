import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';
import { Container, Header } from 'semantic-ui-react';
import Ticket from './Tickets/Ticket';
import NoTickets from './Tickets/NoTickets';
import TicketLoading from './Tickets/TicketLoading';
import PostTicket from './Tickets/PostTicket';

export default function Dashboard() {
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);
  const tickets = useSelector((state) => state.tickets.tickets);
  const [getIsFetching, setIsFetching] = useState(true);
  const [getIsEditing, setIsEditing] = useState(false);

  const updateSection = () => {};

  useEffect(() => {
    setIsFetching(true);
    dispatch(getCurrentUser());
    setIsFetching(false);
  }, []);

  if (getIsFetching) {
    return <TicketLoading />;
  }

  return (
    <>
      <Container textAlign="center">
        <Header as="h2">Dashboard</Header>
        {tickets.length > 0 ? (
          tickets.map((ticket) => {
            return (
              <Ticket
                key={ticket.ticket.ticketid + 'comp'}
                ticketData={ticket}
              />
            );
          })
        ) : (
          <NoTickets />
        )}
      </Container>
    </>
  );
}
