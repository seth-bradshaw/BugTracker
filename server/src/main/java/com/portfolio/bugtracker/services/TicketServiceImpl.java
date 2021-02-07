package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    @Autowired
    UserService userService;

    @Override
    public Ticket save(Ticket ticket) throws Exception
    {
        if (ticket.getCompanies().size() > 0)
        {
            throw new Exception("Only one company per ticket.");
        }

        Ticket newTicket = new Ticket();

        if (ticket.getTicketid() != 0)
        {
            ticketRepository.findById(ticket.getTicketid())
                    .orElseThrow(() -> new EntityNotFoundException("Ticket with id " + ticket.getTicketid() + " not found!"));
            newTicket.setTicketid(ticket.getTicketid());
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null)
        {
            User user = userService.findByUsername(authentication.getName());
            newTicket.setUser(user);
        }
        //before deployment uncomment.
//        else {
//            throw new Exception("Invalid User");
//        }

        newTicket.setTitle(ticket.getTitle());
        newTicket.setDescription(ticket.getDescription());
        newTicket.setStatus(ticket.getStatus());
        newTicket.setErrorcode(ticket.getErrorcode());
        newTicket.setErrorcategory(ticket.getErrorcategory());
        newTicket.setNotes(ticket.getNotes());


        return ticketRepository.save(newTicket);
    }

    @Override
    public Ticket findTicketById(long ticketid) throws Exception
    {
        return ticketRepository.findById(ticketid).orElseThrow(() ->  new Exception("Ticket not found!"));
    }

    @Override
    public void deleteAllTickets()
    {
        ticketRepository.deleteAll();
    }

    @Override
    public void deleteTicketById(long ticketid)
    {
        ticketRepository.deleteById(ticketid);
    }
}
