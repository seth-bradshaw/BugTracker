import React, { useEffect, useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getCurrentUser } from '../store/actions/UserActions';
import { useHistory } from 'react-router-dom';
import { Container, Header, Divider } from 'semantic-ui-react';
import EditTicket from './Tickets/EditTicket';
import NoTickets from './Tickets/NoTickets';
import TicketLoading from './Tickets/TicketLoading';
import PostTicket from './Tickets/PostTicket';
import TicketBoard from './Tickets/TicketBoard';
import TestTicketBoard from './Tickets/TestTicketBoard';
import StatusFilter from './StatusFilter';
import { filterTicketsByNotStarted,  filterTicketsByInProgress} from '../store/actions/TicketActions';

export default function Dashboard() {
  const { push } = useHistory();
  const dispatch = useDispatch();
  const currentUser = useSelector((state) => state.user);
  const tickets = useSelector((state) => state.tickets.tickets);
  const notStartedStatus = useSelector((state) => state.tickets.notStarted);
  const inProgressStatus = useSelector((state) => state.tickets.inProgress);
  const completedStatus = useSelector((state) => state.tickets.completed);
  const displayAllTickets = useSelector((state) => state.tickets.displayAllTickets);
  const [getIsFetching, setIsFetching] = useState(true);
  const [getIsEditing, setIsEditing] = useState(false);
  



  const updateSection = () => {};

  useEffect(() => {
    setIsFetching(true);
    // dispatch(getCurrentUser());
    // dispatch(filterTicketsByNotStarted())
    setIsFetching(false);
  }, []);

  if (getIsFetching) {
    return <TicketLoading />;
  }


  
  return (
    <>
      <Container textAlign="center" style={{ marginTop: '20px' }}>
        <Header as="h2">Welcome {currentUser.username}</Header>
        <StatusFilter >Status</StatusFilter>
        {displayAllTickets ?
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
        :
        null
        }
        {notStartedStatus ?
          tickets.filter(ticket => ticket.ticket.status === "Not Started").map((ticket) => {
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
        :
        null
        }
        {inProgressStatus ?
          tickets.filter(ticket => ticket.ticket.status === "In Progress").map((ticket) => {
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
        :
        null
        }
        {completedStatus ?
          tickets.filter(ticket => ticket.ticket.status === "Completed").map((ticket) => {
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
        :
        null
        }
        <button onClick={() => push('/companyemployees')}>COMPANY EMPLOYEES TEMP BUTTON</button>
      </Container>
      <TestTicketBoard/>
    </>
  );
}
