package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.CompanyEmployees;

public interface CompanyEmployeesService
{
    CompanyEmployees save(long userid, long roleid) throws Exception;
}
