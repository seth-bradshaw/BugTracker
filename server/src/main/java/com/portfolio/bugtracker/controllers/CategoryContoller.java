package com.portfolio.bugtracker.controllers;

import com.portfolio.bugtracker.models.Category;
import com.portfolio.bugtracker.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoryContoller
{
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/category/{categoryid}", produces = "application/json")
    public ResponseEntity<?> getCategoryById(@PathVariable long categoryid)
    {
        Category category = categoryService.findById(categoryid);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<?> getAllCategories()
    {
        List<Category> categoryList = categoryService.findAllCategories();

        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping(value = "/categories", consumes = "application/json")
    public ResponseEntity<?> addNewCategory(@RequestBody @Valid Category newCategory) throws Exception
    {
        newCategory.setCategoryid(0);
        newCategory = categoryService.save(newCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/category/{categoryid}", consumes = "application/json")
    public ResponseEntity<?> editExistingCategory(@RequestBody @Valid Category editedFullCategory, @PathVariable long categoryid) throws Exception
    {
        editedFullCategory.setCategoryid(categoryid);
        editedFullCategory = categoryService.save(editedFullCategory);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/category/{categoryid}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable long categoryid)
    {
        categoryService.deleteCategoryById(categoryid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
