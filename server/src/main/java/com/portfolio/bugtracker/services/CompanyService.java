package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Company;

public interface CompanyService
{
    Company save(Company company) throws Exception;

    Company findCompanyById(long companyid) throws Exception;
}
