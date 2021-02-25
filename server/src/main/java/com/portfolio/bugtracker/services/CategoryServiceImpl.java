package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Category;
import com.portfolio.bugtracker.models.Ticket;
import com.portfolio.bugtracker.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "categoryservice")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    public Category findById(long categoryid)
    {
        Category category = categoryRepository.findById(categoryid).orElseThrow(() -> new EntityNotFoundException("Category with id " + categoryid + " not found!"));
        return category;
    }

    @Override
    public Category save(Category cat1) throws Exception
    {
        Category category = new Category();
        if (cat1.getCategoryid() != 0)
        {
            categoryRepository.findById(cat1.getCategoryid())
                    .orElseThrow(() -> new EntityNotFoundException("Category with id " + cat1.getCategoryid() + " not found!"));
            category.setCategoryid(cat1.getCategoryid());
        }

        category.setCategorytype(cat1.getCategorytype());

        category.getTickets().clear();
        if (cat1.getTickets().size() > 0)
        {
//            for (TicketCategories tc : cat1.getTickets())
//            {
//                Ticket ticket = ticketService.findTicketById(tc.getTicket().getTicketid());
//
//                category.getTickets().add(new TicketCategories(ticket, category));
//            }
        }

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories()
    {
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categoryList::add);

        return categoryList;
    }


    @Override
    public void deleteCategoryById(long categoryid)
    {
        categoryRepository.deleteById(categoryid);
    }
}
