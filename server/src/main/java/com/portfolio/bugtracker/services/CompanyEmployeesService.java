package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.CompanyEmployees;

/**
 * The interface Company employees service.
 */
public interface CompanyEmployeesService
{
    /**
     * Save company employees.
     *
     * @param userid the userid
     * @param roleid the roleid
     * @return the company employees
     * @throws Exception the exception
     */
    CompanyEmployees save(long userid, long roleid) throws Exception;
}
