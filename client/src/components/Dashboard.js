import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';
import { useHistory } from 'react-router-dom';
import { Container, Header, Divider } from 'semantic-ui-react';
import EditTicket from './Tickets/EditTicket';
import NoTickets from './Tickets/NoTickets';
import TicketLoading from './Tickets/TicketLoading';
import PostTicket from './Tickets/PostTicket';

export default function Dashboard() {
  const { push } = useHistory();
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);
  const tickets = useSelector((state) => state.tickets.tickets);
  const [getIsFetching, setIsFetching] = useState(true);
  const [getIsEditing, setIsEditing] = useState(false);

  const updateSection = () => {};

  useEffect(() => {
    setIsFetching(true);
    // dispatch(getCurrentUser());
    setIsFetching(false);
  }, []);

  if (getIsFetching) {
    return <TicketLoading />;
  }

  return (
    <>
      <Container textAlign="center" style={{ marginTop: '20px' }}>
        <Header as="h2">Welcome {currentUser.username}</Header>
        {tickets.length > 0 ? (
          tickets.map((ticket) => {
            return (
              <>
                <EditTicket
                  key={ticket.ticket.ticketid + 'edit'}
                  ticketData={ticket}
                />
                <Divider />
              </>
            );
          })
        ) : (
          <NoTickets />
        )}
        <button onClick={() => push('/companyemployees')}>COMPANY EMPLOYEES TEMP BUTTON</button>
      </Container>
    </>
  );
}
