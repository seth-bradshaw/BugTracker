package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.TicketStatuses;

public interface TicketStatusesService
{
    TicketStatuses save(TicketStatuses ticketStatuses) throws Exception;

}
