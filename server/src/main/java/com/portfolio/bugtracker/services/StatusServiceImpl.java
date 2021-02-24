package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Status;
import com.portfolio.bugtracker.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "statusservice")
public class StatusServiceImpl implements StatusService
{
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Status findByStatusId(long statusid)
    {
        Status status = statusRepository.findById(statusid).orElseThrow(() -> new EntityNotFoundException("Status with id " + statusid + " not found!"));

        return status;
    }

    @Override
    public Status save(Status s1)
    {
        Status status = statusRepository.save(s1);
        return status;
    }
}
