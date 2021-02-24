package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Status;

public interface StatusService
{
    Status findByStatusId(long statusid);

    Status save(Status s1);
}
