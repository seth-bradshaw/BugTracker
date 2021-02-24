package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long>
{
}
