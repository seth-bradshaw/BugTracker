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
    public Company save(Company c1)
    {
        return companyRepository.save(c1);
    }

    @Override
    public Company findCompanyById(long companyid) throws Exception
    {
        return companyRepository.findById(companyid).orElseThrow(() -> new Exception("Company not found!"));
    }
}
