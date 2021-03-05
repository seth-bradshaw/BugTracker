package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/tickets")
@RestController
public class TicketController
{
    @Autowired
    private TicketService ticketService;

    //admin or user assigned to ticket (STILL NEED TO IMPLEMENT THIS FUNCIONALITY FOR USER ASSIGNED)
    //Endpoint to fetch a single ticket by id. Will return the requested ticket.
    @GetMapping(value = {"/ticket/{ticketid}"}, produces = "application/json")
    public ResponseEntity<?> fetchSingleTicket(@PathVariable long ticketid) throws Exception
    {
        Ticket ticket = ticketService.findTicketById(ticketid);

        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

    //admin
    @GetMapping(value = "/tickets", produces = "application/json")
    public ResponseEntity<?> fetchingAllTickets()
    {
        List<Ticket> ticketList = ticketService.findAllTickets();

        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping(value = "/tickets/user/{userid}", produces = "application/json")
    public ResponseEntity<?> fetchTicketsByUserId(@PathVariable long userid)
    {
        List<Ticket> ticketList = ticketService.findAllTicketsByUserId(userid);

        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    //authenticated
    //Endpoint to add a new ticket. Will return created status, but not the new ticket object.
    @PostMapping(value = {"/tickets"}, consumes = "application/json")
    public ResponseEntity<?> addNewTicket(@Valid @RequestBody Ticket newTicket) throws Exception
    {
        newTicket.setTicketid(0);
        Ticket ticket = ticketService.save(newTicket);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //authenticated
    //Endpoint to edit an existing ticket by id. Will return successful status, but not the new ticket object.
    @PutMapping(value = {"/ticket/{ticketid}"}, consumes = "application/json")
    public ResponseEntity<?> editExistingTicket(@PathVariable long ticketid, @Valid @RequestBody Ticket editedTicket) throws Exception
    {
        editedTicket.setTicketid(ticketid);
        Ticket ticket = ticketService.save(editedTicket);

        return new ResponseEntity<>(ticket, HttpStatus.ACCEPTED);
    }

    //authenticated
    //Endpoint to delete an existing ticket.
    @DeleteMapping(value = {"/ticket/{ticketid}"})
    public ResponseEntity<?> deleteTicket(@PathVariable long ticketid)
    {
        ticketService.deleteTicketById(ticketid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
