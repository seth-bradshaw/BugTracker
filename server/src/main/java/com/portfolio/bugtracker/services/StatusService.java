package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Status;

import java.util.List;
import java.util.Set;

public interface StatusService
{
    Status findByStatusId(long statusid);

    Status save(Status s1) throws Exception;

    List<Status> findAllStatuses();

    void deleteStatusById(long statusid);

    Set<Status> findStatusByUser() throws Exception;
}
