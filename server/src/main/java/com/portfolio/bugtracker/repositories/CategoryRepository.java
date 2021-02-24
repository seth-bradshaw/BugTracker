package com.portfolio.bugtracker.repositories;

import com.portfolio.bugtracker.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{
}
