package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.*;
import com.portfolio.bugtracker.repositories.CompanyEmployeesRespository;
import com.portfolio.bugtracker.repositories.CompanyRepository;
import com.portfolio.bugtracker.repositories.CompanyTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    CompanyRepository companyRepository;

    @Autowired
    CompanyEmployeesRespository companyEmployeesRespository;

    @Autowired
    CompanyTicketsRepository companyTicketsRepository;

    @Override
    public Company save(Company company) throws Exception
    {
        if (company.getEmployees().size() > 0)
        {
            throw new Exception("Employees cannot be included in post to Company.");
        }

        Company newCompany = new Company();

        newCompany.setCompanyname(company.getCompanyname());

//        if ()
//        for (CompanyEmployees e : company.getEmployees())
//        {
//            CompanyEmployees companyEmployees = companyEmployeesRespository.findById(new CompanyEmployeesId(e.getCompany().getCompanyid(), e.getEmployee().getUserid()))
//                    .orElse(new CompanyEmployees(e.getCompany(), e.getEmployee()));
//
//            newCompany.getEmployees().add(companyEmployees);
//            companyEmployeesRespository.save(companyEmployees);
//        }
//
//        for (CompanyTickets t : company.getTickets())
//        {
//            CompanyTickets companyTickets = companyTicketsRepository.findById(new CompanyTicketsId(t.getCompany().getCompanyid(), t.getTicket().getTicketid()))
//                    .orElse(new CompanyTickets(t.getCompany(), t.getTicket()));
//
//            newCompany.getTickets().add(companyTickets);
//            companyTicketsRepository.save(companyTickets);
//        }

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
