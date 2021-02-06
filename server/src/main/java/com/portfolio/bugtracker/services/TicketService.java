package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Ticket;

/**
 * The interface Ticket service.
 */
public interface TicketService
{
    /**
     * Save ticket.
     *
     * @param ticket the ticket
     * @return the ticket
     * @throws Exception the exception
     */
    Ticket save(Ticket ticket) throws Exception;
    
    /**
     * Find ticket by id ticket.
     *
     * @param ticketid the ticketid
     * @return the ticket
     * @throws Exception the exception
     */
    Ticket findTicketById(long ticketid) throws Exception;
}
