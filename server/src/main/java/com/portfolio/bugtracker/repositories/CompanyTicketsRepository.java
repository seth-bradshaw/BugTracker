package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.CompanyTickets;
import com.portfolio.bugtracker.models.CompanyTicketsId;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Company tickets repository.
 */
public interface CompanyTicketsRepository extends CrudRepository<CompanyTickets, CompanyTicketsId>
{
}
