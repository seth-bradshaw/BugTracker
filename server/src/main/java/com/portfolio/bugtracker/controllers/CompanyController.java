package com.portfolio.bugtracker.controllers;
import com.portfolio.bugtracker.models.Company;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.User;
import com.portfolio.bugtracker.services.CompanyService;
import com.portfolio.bugtracker.services.TicketService;
import com.portfolio.bugtracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping(value = "/companies")
@RestController
public class CompanyController
{
    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    //admin
    //Endpoint to access a company by id. Will only return the requested company object.
    @GetMapping(value = "/company/{companyid}", produces = "application/json")
    public ResponseEntity<?> fetchUserById(@PathVariable long companyid) throws Exception
    {
        Company rtnComp = companyService.findCompanyById(companyid);

        return new ResponseEntity<>(rtnComp, HttpStatus.OK);
    }

    //admin
    //Endpoint to access a specific companies list of employees.
    @GetMapping(value = "/company/{companyid}/users", produces = "application/json")
    public ResponseEntity<?> fetchCompanyEmployees(@PathVariable long companyid)
    {
        List<User> companyUsers = userService.fetchUsersByCompany(companyid);

        return new ResponseEntity<>(companyUsers, HttpStatus.OK);
    }

//    //admin
//    @GetMapping(value = "/company/{companyid}/tickets", produces = "application/json")
//    public ResponseEntity<?> fetchCompanyTickets(@PathVariable long companyid) throws Exception
//    {
//        Set<Ticket> companyTickets = ticketService.fetchTicketsByCompany(companyid);
//
//        return new ResponseEntity<>(companyTickets, HttpStatus.OK);
//    }

    //admin
    //Endpoint to create a new company. This will only return a created status, no body will be returned from the server.
    @PostMapping(value = "/company/add", consumes = "application/json")
    public ResponseEntity<?> addNewCompany(@Valid @RequestBody Company newCompany) throws Exception
    {
        newCompany.setCompanyid(0);
        companyService.save(newCompany);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //admin
    //Endpoint to edit an existing company by id. This will only return a status.
    @PutMapping(value = "/company/{companyid}", consumes = "application/json")
    public ResponseEntity<?> editExistingCompany(@PathVariable long companyid, @Valid @RequestBody Company newCompany) throws Exception
    {
        newCompany.setCompanyid(companyid);
        newCompany = companyService.save(newCompany);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //admin
    //Endpoint to delete an existing company by id.
    @DeleteMapping(value = "/company/{companyid}")
    public ResponseEntity<?> deleteCompany(@PathVariable long companyid)
    {
        companyService.deleteCompanyById(companyid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
