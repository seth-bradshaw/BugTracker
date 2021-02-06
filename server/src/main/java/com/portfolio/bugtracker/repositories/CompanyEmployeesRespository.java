package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.CompanyEmployees;
import com.portfolio.bugtracker.models.CompanyEmployeesId;
import org.springframework.data.repository.CrudRepository;

public interface CompanyEmployeesRespository extends CrudRepository<CompanyEmployees, CompanyEmployeesId>
{
}
