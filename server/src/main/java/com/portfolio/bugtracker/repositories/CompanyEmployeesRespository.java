package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.CompanyEmployees;
import com.portfolio.bugtracker.models.CompanyEmployeesId;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Company employees respository.
 */
public interface CompanyEmployeesRespository extends CrudRepository<CompanyEmployees, CompanyEmployeesId>
{
}
