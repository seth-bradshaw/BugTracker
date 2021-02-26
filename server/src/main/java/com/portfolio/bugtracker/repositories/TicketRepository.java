package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * The interface Ticket repository.
 */
public interface TicketRepository extends CrudRepository<Ticket, Long>
{
//    try to get this to work properly in release 2
//    @Query(value = "SELECT t.ticketid, t.errorcode, t.notes, t.description, t.severity, t.title, cat.categoryid FROM Ticket t, User u, Company c JOIN Category cat ON t.category.categoryid = cat.categoryid WHERE t.user.userid = u.userid and c.companyid = ?1")
//    List<Ticket> fetchTicketsByCompany(long companyid);
}
