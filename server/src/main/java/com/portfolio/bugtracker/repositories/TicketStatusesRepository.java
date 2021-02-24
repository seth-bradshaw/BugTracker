package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.TicketStatuses;
import com.portfolio.bugtracker.models.TicketStatusesId;
import org.springframework.data.repository.CrudRepository;

public interface TicketStatusesRepository extends CrudRepository<TicketStatuses, TicketStatusesId>
{
}
