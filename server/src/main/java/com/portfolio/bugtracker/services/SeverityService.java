package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Severity;

public interface SeverityService
{
    Severity findBySeverityId(long severityid);

    Severity save(Severity sev1);
}
