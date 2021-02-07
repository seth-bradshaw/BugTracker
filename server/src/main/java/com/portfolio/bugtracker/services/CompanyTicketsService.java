package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.CompanyTickets;
import com.portfolio.bugtracker.models.Ticket;

import java.util.List;

/**
 * The interface Company tickets service.
 */
public interface CompanyTicketsService
{
    /**
     * Save company tickets.
     *
     * @param companyid the companyid
     * @param ticketid  the ticketid
     * @return the company tickets
     * @throws Exception the exception
     */
    CompanyTickets save(long companyid, long ticketid) throws Exception;

    List<Ticket> fetchCompanyTickets(long companyid) throws Exception;

    void deleteAllCompanyTickets();
}
