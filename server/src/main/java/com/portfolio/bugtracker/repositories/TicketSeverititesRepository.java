package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.TicketSeverities;
import com.portfolio.bugtracker.models.TicketSeveritiesId;
import org.springframework.data.repository.CrudRepository;

public interface TicketSeverititesRepository extends CrudRepository<TicketSeverities, TicketSeveritiesId>
{
}
