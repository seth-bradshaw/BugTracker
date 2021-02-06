package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long>
{
}
