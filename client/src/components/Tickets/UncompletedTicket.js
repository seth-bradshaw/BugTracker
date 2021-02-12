import React, {useState} from 'react';
import {useSelector} from 'react-redux';
import Ticket from './Ticket';

export default function UncompleteTicket() {
    const tickets = useSelector((state) => state.tickets);
    const user = useSelector((state) => state.user);
    console.log(tickets, user);
    return (
        <div>
            {
                tickets.tickets.map(ticket => {
                    if(ticket.status !== "Completed")
                    {
                        return <Ticket ticket={ticket.ticket}/>
                    }
                })
            }
        </div>
    )
}
