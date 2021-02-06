package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.CompanyTickets;

public interface CompanyTicketsService
{
    CompanyTickets save(long companyid, long ticketid) throws Exception;
}
