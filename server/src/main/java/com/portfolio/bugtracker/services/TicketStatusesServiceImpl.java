package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.TicketStatuses;
import com.portfolio.bugtracker.models.TicketStatusesId;
import com.portfolio.bugtracker.repositories.TicketStatusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ticketstatusesservices")
public class TicketStatusesServiceImpl implements TicketStatusesService
{
    @Autowired
    private TicketStatusesRepository ticketStatusesRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private StatusService statusService;
    @Override
    public TicketStatuses save(TicketStatuses ticketStatuses) throws Exception
    {
        //same here
//        Ticket ticket = ticketService.findTicketById(ticketStatuses.getTicket().getTicketid());
//        Status status = statusService.findByStatusId(ticketStatuses.getStatus().getStatusid());
        TicketStatuses ticketStatuses1 = ticketStatusesRepository.findById(new TicketStatusesId(ticketStatuses.getTicket().getTicketid(), ticketStatuses.getStatus().getStatusid()))
                .orElse(new TicketStatuses(ticketStatuses.getTicket(), ticketStatuses.getStatus()));

        return ticketStatusesRepository.save(ticketStatuses1);
    }

}
