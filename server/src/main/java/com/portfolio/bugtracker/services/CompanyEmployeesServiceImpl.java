package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.models.CompanyEmployees;
import com.portfolio.bugtracker.models.CompanyEmployeesId;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.repositories.CompanyEmployeesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Company employees service.
 */
@Service(value = "companyEmployeesService")
public class CompanyEmployeesServiceImpl implements CompanyEmployeesService
{
    /**
     * The Company employees respository.
     */
    @Autowired
    CompanyEmployeesRespository companyEmployeesRespository;
    
    /**
     * The User service.
     */
    @Autowired
    UserService userService;
    
    /**
     * The Company service.
     */
    @Autowired
    CompanyService companyService;

    @Override
    public CompanyEmployees save(long companyid, long userid) throws Exception
    {
        User employee = userService.findUserById(userid);
        Company company = companyService.findCompanyById(companyid);
        CompanyEmployees companyEmployees = companyEmployeesRespository.findById(new CompanyEmployeesId(companyid, userid)).orElse(new CompanyEmployees(company, employee));

        return companyEmployeesRespository.save(companyEmployees);
    }
}
