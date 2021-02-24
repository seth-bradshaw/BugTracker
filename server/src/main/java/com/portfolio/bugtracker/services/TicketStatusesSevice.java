package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.TicketStatuses;

public interface TicketStatusesSevice
{
    TicketStatuses save(TicketStatuses ticketStatuses) throws Exception;
}
