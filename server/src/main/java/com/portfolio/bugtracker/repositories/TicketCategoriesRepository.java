package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.TicketCategories;
import com.portfolio.bugtracker.models.TicketCategoriesId;
import org.springframework.data.repository.CrudRepository;

public interface TicketCategoriesRepository extends CrudRepository<TicketCategories, TicketCategoriesId>
{
}
