package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Ticket service.
 */
@Service(value = "ticketService")
public class TicketServiceImpl implements TicketService
{
    /**
     * The Ticket repository.
     */
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket save(Ticket ticket) throws Exception
    {
//        if (ticket.getCompanies().size() > 0)
//        {
//            throw new Exception("Companies not changed through Ticket");
//        }
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicketById(long ticketid) throws Exception
    {
        return ticketRepository.findById(ticketid).orElseThrow(() ->  new Exception("Ticket not found!"));
    }
}
