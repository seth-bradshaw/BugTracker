package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.*;
import com.portfolio.bugtracker.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * The type Company service.
 */
@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService
{
    /**
     * The Company repository.
     */
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserService userService;

    @Override
    public Company save(Company company) throws Exception
    {
        if (company.getUsers().size() > 0)
        {
            throw new Exception("Users cannot be included in post to Company.");
        }

        Company newCompany = new Company();

        if (company.getCompanyid() != 0)
        {
            companyRepository.findById(company.getCompanyid())
                    .orElseThrow(() ->  new EntityNotFoundException("Company with " + company.getCompanyid() + " not found!"));

            newCompany.setCompanyid(company.getCompanyid());
        }
        //uncomment for deployment
//        else
//        {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            User user = userService.findByUsername(authentication.getName());
//
//            newCompany.getUsers().add(user);
//        }

        newCompany.setCompanyname(company.getCompanyname());

        newCompany = companyRepository.save(company);

        return newCompany;
    }

    @Override
    public Company findCompanyById(long companyid) throws Exception
    {
        return companyRepository.findById(companyid).orElseThrow(() -> new Exception("Company not found!"));
    }

    @Override
    public void deleteAllCompanies()
    {
        companyRepository.deleteAll();
    }

    @Override
    public void deleteCompanyById(long companyid)
    {
        companyRepository.deleteById(companyid);
    }
}
