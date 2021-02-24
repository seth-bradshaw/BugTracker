package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.Severity;
import com.portfolio.bugtracker.services.SeverityService;
import com.portfolio.bugtracker.services.TicketService;
import com.portfolio.bugtracker.services.TicketSeveritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "/severities")
@RestController
public class SeverityController
{
    @Autowired
    private SeverityService severityService;

    @Autowired
    private TicketSeveritiesService ticketSeveritiesService;

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/severity/{severityid}", produces = "application/json")
    public ResponseEntity<?> getSeverityById(@PathVariable long severityid)
    {
        Severity severity = severityService.findBySeverityId(severityid);

        return new ResponseEntity<>(severity, HttpStatus.OK);
    }

    @GetMapping(value = "/severities", produces = "application/json")
    public ResponseEntity<?> getAllSeverities()
    {
        List<Severity> severityList = severityService.findAllSeverties();

        return new ResponseEntity<>(severityList, HttpStatus.OK);
    }

    @PostMapping(value = "/severities", consumes = "application/json")
    public ResponseEntity<?> addNewSeverity(@RequestBody @Valid Severity newSeverity) throws Exception
    {
        newSeverity.setSeverityid(0);
        newSeverity = severityService.save(newSeverity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/severity/{severityid}", consumes = "application/json")
    public ResponseEntity<?> editFullSeverity(@RequestBody @Valid Severity editedFullSeverity, @PathVariable long severityid) throws Exception
    {
        editedFullSeverity.setSeverityid(severityid);
        editedFullSeverity = severityService.save(editedFullSeverity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping(value = "/editseverity/{severityid}", consumes = "application/json")
    public ResponseEntity<?> partiallyEditSeverity(@RequestBody Severity partiallyEditedSeverity, @PathVariable long severityid) throws Exception
    {
        partiallyEditedSeverity.setSeverityid(severityid);
        partiallyEditedSeverity = severityService.edit(partiallyEditedSeverity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/severity/{severityid}")
    public ResponseEntity<?> deleteSeverityById(@PathVariable long severityid)
    {
        severityService.deleteSeverityById(severityid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
