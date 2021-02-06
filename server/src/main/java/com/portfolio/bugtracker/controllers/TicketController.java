package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.services.CompanyTicketsService;
import com.portfolio.bugtracker.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TicketController
{
    @Autowired
    TicketService ticketService;

    @Autowired
    CompanyTicketsService companyTicketsService;

    //Endpoint to fetch a single ticket by id. Will return the requested ticket.
    @GetMapping(value = {"/ticket/{ticketid}"}, produces = "application/json")
    public ResponseEntity<?> fetchSingleTicket(@PathVariable long ticketid) throws Exception
    {
        Ticket ticket = ticketService.findTicketById(ticketid);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    //Endpoint to add a new ticket. Will return created status, but not the new ticket object.
    @PostMapping(value = {"/company/{companyid}/ticket/add"}, consumes = "application/json")
    public ResponseEntity<?> addNewTicket(@PathVariable long companyid, @Valid @RequestBody Ticket newTicket) throws Exception
    {
        Ticket ticket = ticketService.save(newTicket);
        companyTicketsService.save(companyid, ticket.getTicketid());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
