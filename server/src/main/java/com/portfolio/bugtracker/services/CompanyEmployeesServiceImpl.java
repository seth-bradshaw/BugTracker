package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.models.CompanyEmployees;
import com.portfolio.bugtracker.models.CompanyEmployeesId;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.repositories.CompanyEmployeesRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.bugtracker.models.User;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> fetchCompanyEmployees(long companyid)
    {
        List<CompanyEmployees> companyEmployees = new ArrayList<>();
        companyEmployeesRespository.findAll().iterator().forEachRemaining(companyEmployees::add);
        List<User> employees = new ArrayList<>();
        for (CompanyEmployees ce : companyEmployees)
        {
            if (ce.getCompany().getCompanyid() == companyid)
            {
                employees.add(ce.getEmployee());
            }
        }

        return employees;
    }

    @Override
    public void deleteAllCompanyEmployees()
    {
        companyEmployeesRespository.deleteAll();
    }
}
