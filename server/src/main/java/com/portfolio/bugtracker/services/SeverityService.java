package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Severity;

import java.util.List;

public interface SeverityService
{
    Severity findBySeverityId(long severityid);

    Severity save(Severity sev1) throws Exception;

    List<Severity> findAllSeverties();

    void deleteSeverityById(long severityid);

    Severity edit(Severity partiallyEditedSeverity) throws Exception;
}
