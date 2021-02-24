package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.TicketSeverities;

public interface TicketSeveritiesService
{
    TicketSeverities save(TicketSeverities ticketSeverities) throws Exception;
}
