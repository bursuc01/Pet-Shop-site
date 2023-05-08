package com.example.petshop.Controller;

import com.example.petshop.Model.Category;
import com.example.petshop.Repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This class manages the http requests for the category model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<Category>
     *
     *  This method executes a get request and returns all available Category
     */
    @GetMapping("/getCategory")
    public List<Category> all() {
        return repository.findAll();
    }


    /**
     *
     * @param newCategory Category
     * @return Category
     *
     *  This method executes a post request and creates a new Category
     */
    @PostMapping("/createCategory")
    public Category newCategory(@RequestBody Category newCategory) {
        return repository.save(newCategory);
    }


    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing Category
     */
    @DeleteMapping("/deleteCategory")
    public void deleteCategory(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newCategory Category
     * @return Category
     *
     *  This method executes an update request and updates an existing Category
     */
    @PutMapping("/putCategory")
    public Category updateCategory(@RequestBody Category newCategory){return repository.save(newCategory);}
}
