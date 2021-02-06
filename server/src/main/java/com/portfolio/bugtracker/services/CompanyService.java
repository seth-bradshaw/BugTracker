package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Company;

/**
 * The interface Company service.
 */
public interface CompanyService
{
    /**
     * Save company.
     *
     * @param company the company
     * @return the company
     * @throws Exception the exception
     */
    Company save(Company company) throws Exception;
    
    /**
     * Find company by id company.
     *
     * @param companyid the companyid
     * @return the company
     * @throws Exception the exception
     */
    Company findCompanyById(long companyid) throws Exception;

    void deleteAllCompanies();
}
