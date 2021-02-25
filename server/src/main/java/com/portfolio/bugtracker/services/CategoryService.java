package com.portfolio.bugtracker.services;

import com.portfolio.bugtracker.models.Category;

import java.util.List;

public interface CategoryService
{
    Category findById(long categoryid);

    Category save(Category cat1) throws Exception;

    List<Category> findAllCategories();

    void deleteCategoryById(long categoryid);
}
