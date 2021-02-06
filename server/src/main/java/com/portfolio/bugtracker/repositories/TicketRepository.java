package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Ticket;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Ticket repository.
 */
public interface TicketRepository extends CrudRepository<Ticket, Long>
{
}
