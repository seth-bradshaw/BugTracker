package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.*;
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

    @Autowired
    TicketCategoriesService ticketCategoriesService;

    @Autowired
    TicketStatusesService ticketStatusesService;

    @Autowired
    TicketSeveritiesService ticketSeveritiesService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StatusService statusService;

    @Autowired
    SeverityService severityService;

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
        newTicket.setErrorcode(ticket.getErrorcode());
        newTicket.setNotes(ticket.getNotes());

        if (ticket.getCategories() != null)
        {
            for (TicketCategories tc : ticket.getCategories())
            {
                Category category = categoryService.findById(tc.getCategory().getCategoryid());
                ticketCategoriesService.save(new TicketCategories(tc.getTicket(), category));
            }
        }

        if (ticket.getStatuses() != null)
        {
            for (TicketStatuses ts : ticket.getStatuses())
            {
                Status status = statusService.findByStatusId(ts.getStatus().getStatusid());
                ticketStatusesService.save(new TicketStatuses(ts.getTicket(), status));
            }
        }

        if (ticket.getSeverities() != null)
        {
            for (TicketSeverities ts : ticket.getSeverities())
            {
                Severity severity = severityService.findBySeverityId(ts.getSeverity().getSeverityid());
                ticketSeveritiesService.save(new TicketSeverities(ts.getTicket(), severity));
            }
        }

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
