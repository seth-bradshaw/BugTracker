package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company save(Company company) throws Exception
    {
        if (company.getEmployees().size() > 0)
        {
            throw new Exception("Employees not changed through company");
        }
        return companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(long companyid) throws Exception
    {
        return companyRepository.findById(companyid).orElseThrow(() -> new Exception("Company not found!"));
    }
}
