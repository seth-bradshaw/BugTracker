package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long>
{
}
