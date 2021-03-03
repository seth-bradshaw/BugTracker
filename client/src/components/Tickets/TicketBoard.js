import React, { useState, useEffect } from 'react';
import axios from 'axios';
import TicketBoardColumn from './TicketBoardColumn';

export default function TicketBoard() {
  const [tickets, setTickets] = useState([]);
  const completed = [];
  const notStarted = [];

  useEffect(() => {
    axios
      .get('http://localhost:2019/tickets/tickets')
      .then(res => {
        setTickets(res.data);
      })
      .catch(err => {
        console.log(err);
      });
  }, []);

  tickets.forEach(tkt => {
    if (tkt.status.statustype === 'Completed. Testing') {
      completed.push(tkt);
      // console.log("COMPLETED", completed)
    } else if (tkt.status.statustype === 'Not started. Testing') {
      notStarted.push(tkt);
      // console.log("NOT STARTED", notStarted)
    }
  });

  return (
    <div style={{ border: '2px solid red', display: 'flex' }}>
      <TicketBoardColumn tickets={notStarted} />
      <TicketBoardColumn tickets={completed} />
    </div>
  );
}
