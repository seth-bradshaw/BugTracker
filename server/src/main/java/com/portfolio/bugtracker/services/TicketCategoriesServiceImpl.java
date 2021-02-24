package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Category;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.models.TicketCategories;
import com.portfolio.bugtracker.models.TicketCategoriesId;
import com.portfolio.bugtracker.repositories.TicketCategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ticketcategoriesservice")
public class TicketCategoriesServiceImpl implements TicketCategoriesService
{
    @Autowired
    private TicketCategoriesRepository ticketCategoriesRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public TicketCategories save(TicketCategories ticketCategories) throws Exception
    {
        //thinking rn that we only send valid objects so we don't have to validate multiple times.
//        Ticket ticket = ticketService.findTicketById(ticketCategories.getTicket().getTicketid());
//        Category category = categoryService.findById(ticketCategories.getCategory().getCategoryid());

        TicketCategories ticketCategories1 = ticketCategoriesRepository.findById(new TicketCategoriesId(ticketCategories.getTicket().getTicketid(), ticketCategories.getCategory().getCategoryid()))
                .orElse(new TicketCategories(ticketCategories.getTicket(), ticketCategories.getCategory()));
        return ticketCategoriesRepository.save(ticketCategories1);
    }
}
