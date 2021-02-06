package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Company;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Company repository.
 */
public interface CompanyRepository extends CrudRepository<Company, Long>
{
}
