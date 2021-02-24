package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Severity;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.TicketSeverities;
import com.portfolio.bugtracker.models.TicketSeveritiesId;
import com.portfolio.bugtracker.repositories.TicketSeverititesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ticketseveritiesservice")
public class TicketSeveritiesServiceImpl implements TicketSeveritiesService
{
    @Autowired
    private TicketSeverititesRepository ticketSeverititesRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeverityService severityService;

    @Override
    public TicketSeverities save(TicketSeverities ticketSeverities) throws Exception
    {
        //same here
//        Ticket ticket = ticketService.findTicketById(ticketSeverities.getTicket().getTicketid());
//        Severity severity = severityService.findBySeverityId(ticketSeverities.getSeverity().getSeverityid());
        TicketSeverities ticketSeverities1 = ticketSeverititesRepository.findById(new TicketSeveritiesId(ticketSeverities.getTicket().getTicketid(), ticketSeverities.getSeverity().getSeverityid()))
                .orElse(new TicketSeverities(ticketSeverities.getTicket(), ticketSeverities.getSeverity()));

        return ticketSeverititesRepository.save(ticketSeverities1);
    }
}
