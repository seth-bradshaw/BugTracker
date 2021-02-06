package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Ticket;

public interface TicketService
{
    Ticket save(Ticket ticket);

    Ticket findTicketById(long ticketid) throws Exception;
}
