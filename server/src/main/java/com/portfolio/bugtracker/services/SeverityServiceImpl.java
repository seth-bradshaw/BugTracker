package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Severity;
import com.portfolio.bugtracker.repositories.SeverityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "severityservice")
public class SeverityServiceImpl implements SeverityService
{
    @Autowired
    private SeverityRepository severityRepository;

    @Override
    public Severity findBySeverityId(long severityid)
    {
        Severity severity = severityRepository.findById(severityid)
                .orElseThrow(() ->  new EntityNotFoundException("Severity with id " + severityid + " not found!"));

        return severity;
    }

    @Override
    public Severity save(Severity sev1)
    {
        Severity severity = severityRepository.save(sev1);
        return severity;
    }
}
