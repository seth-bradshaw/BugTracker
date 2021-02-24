package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.TicketCategories;
import com.portfolio.bugtracker.models.TicketCategoriesId;

public interface TicketCategoriesService
{
    TicketCategories save(TicketCategories ticketCategories) throws Exception;
}
