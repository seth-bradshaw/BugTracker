package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Severity;
import org.springframework.data.repository.CrudRepository;

public interface SeverityRepository extends CrudRepository<Severity, Long>
{
}
