package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.Status;
import com.portfolio.bugtracker.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RequestMapping(value = "/statuses")
@RestController
public class StatusController
{
    @Autowired
    private StatusService statusService;

    //authenticated
    @GetMapping(value = "/status/{statusid}", produces = "application/json")
    public ResponseEntity<?> getStatusById(@PathVariable long statusid)
    {
        Status status = statusService.findByStatusId(statusid);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/statuses/user", produces = "application/json")
    public ResponseEntity<?> getStatusesByCompanyId() throws Exception
    {
        Set<Status> statusList = statusService.findStatusByUser();

        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    //authenticated
    @GetMapping(value = "/statuses", produces = "application/json")
    public ResponseEntity<?> getAllStatuses()
    {
        List<Status> statusList = statusService.findAllStatuses();

        return new ResponseEntity<>(statusList, HttpStatus.OK);
    }

    @GetMapping(value = "/status")

    //authenticated
    @PostMapping(value = "/statuses", produces = "application/json")
    public ResponseEntity<?> addNewStatus(@RequestBody @Valid Status newStatus) throws Exception
    {
        newStatus.setStatusid(0);
        newStatus = statusService.save(newStatus);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //admin
    @PutMapping(value = "/status/{statusid}", produces = "application/json")
    public ResponseEntity<?> editFullStatus(@RequestBody @Valid Status editedFullStatus, @PathVariable long statusid) throws Exception
    {
        editedFullStatus.setStatusid(statusid);
        editedFullStatus = statusService.save(editedFullStatus);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //admin
    @DeleteMapping(value = "/status/{statusid}")
    public ResponseEntity<?> deleteStatusById(@PathVariable long statusid)
    {
        statusService.deleteStatusById(statusid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
