import React, { useState, useEffect } from 'react';
import BoardTicket from './BoardTicket';

export default function TicketBoardColumn(props) {
  const { tickets, setTickets } = props;
  const [newTickets, setNewTickets] = useState([]);

  useEffect(() => {
    addTicketsToArr();
  }, []);

  const addTicketsToArr = () => {
    setNewTickets(
      tickets.map(tkt => {
        return tkt;
      })
    );
  };

  const onDragOver = e => {
    e.preventDefault();
  };

  const onDrop = (e, status) => {
    let id = e.dataTransfer.getData('id');
    console.log('ON DROP ID==> ', id);

    let tasks = tickets.filter(tkt => {
      if (tkt.ticketid == id) {
        tkt.status.statustype = status;
      }
      return tkt;
    });

    setNewTickets({ ...tickets, tasks });
    console.log('NEW TICKETS===> ', newTickets);
  };

  return (
    <div
      style={{ border: '2px solid blue' }}
      onDragOver={e => onDragOver(e)}
      onDrop={e => onDrop(e, 'Completed. Testing')}
    >
      {tickets.map(tkt => {
        return <BoardTicket ticket={tkt} />;
      })}
    </div>
  );
}
