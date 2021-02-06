package com.portfolio.bugtracker.services;
import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.models.CompanyTickets;
import com.portfolio.bugtracker.models.CompanyTicketsId;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.repositories.CompanyTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Company tickets service.
 */
@Service(value = "companyTicketsService")
public class CompanyTicketsServiceImpl implements CompanyTicketsService
{
    /**
     * The Company tickets repository.
     */
    @Autowired
    CompanyTicketsRepository companyTicketsRepository;
    
    /**
     * The Company service.
     */
    @Autowired
    CompanyService companyService;
    
    /**
     * The Ticket service.
     */
    @Autowired
    TicketService ticketService;

    @Override
    public CompanyTickets save(long companyid, long ticketid) throws Exception
    {
        Company company = companyService.findCompanyById(companyid);
        Ticket ticket = ticketService.findTicketById(ticketid);
        CompanyTickets companyTickets = companyTicketsRepository.findById(new CompanyTicketsId(company.getCompanyid(), ticket.getTicketid())).orElse(new CompanyTickets(company, ticket));

        return companyTicketsRepository.save(companyTickets);
    }
}
