package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.CompanyTickets;

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
}
