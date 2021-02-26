package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Ticket;

import java.util.List;
import java.util.Set;

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

    void deleteAllTickets();

    void deleteTicketById(long ticketid);

    List<Ticket> findAllTickets();

//    Set<Ticket> fetchTicketsByCompany(long companyid);
}
