package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.*;
import com.portfolio.bugtracker.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    CategoryService categoryService;

    @Autowired
    StatusService statusService;

    @Override
    public Ticket save(Ticket ticket) throws Exception
    {
        Ticket newTicket = new Ticket();

        if (ticket.getTicketid() != 0)
        {
            ticketRepository.findById(ticket.getTicketid())
                    .orElseThrow(() -> new EntityNotFoundException("Ticket with id " + ticket.getTicketid() + " not found!"));
            newTicket.setTicketid(ticket.getTicketid());
        }

        if (ticket.getUsers().size() > 0)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user;
            if (authentication != null)
            {
                user = userService.findByUsername(authentication.getName());
                newTicket.getUsers().add(new UserTickets(user, newTicket));
            }
            else
            {
//                throw new Exception("You must be logged in to access this!");
            }
        }
        else
        {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            User user = userService.findByUsername(authentication.getName());
            //temp fix for seeddata
            newTicket.setUsers(ticket.getUsers());
        }

        newTicket.setTitle(ticket.getTitle());
        newTicket.setDescription(ticket.getDescription());
        newTicket.setErrorcode(ticket.getErrorcode());
        newTicket.setNotes(ticket.getNotes());
        newTicket.setSeverity(ticket.getSeverity());

        if (ticket.getCategory() != null)
        {
            Category category = categoryService.findById(ticket.getCategory().getCategoryid());
            newTicket.setCategory(category);
        }

        if (ticket.getStatus() != null)
        {
            Status status = statusService.findByStatusId(ticket.getStatus().getStatusid());
            newTicket.setStatus(status);
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

    @Override
    public List<Ticket> findAllTickets()
    {
        List<Ticket> ticketList = new ArrayList<>();
        ticketRepository.findAll().iterator().forEachRemaining(ticketList::add);

        return ticketList;
    }
//    FIX THIS BEFORE DEPLOYMENT
//    @Override
//    public Set<Ticket> fetchTicketsByCompany(long companyid)
//    {
//        List<Ticket> ticketList = new ArrayList<>();
//        ticketRepository.findAll().iterator().forEachRemaining(ticketList::add);
//        Set<Ticket> rtnList = new HashSet<>();
//        for (Ticket t : ticketList)
//        {
//            if (t.getUser().getCompany().getCompanyid() == companyid)
//            {
//                rtnList.add(t);
//            }
//        }
//
//        return rtnList;
//    }
}
