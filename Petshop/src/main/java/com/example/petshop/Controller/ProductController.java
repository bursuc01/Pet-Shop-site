package com.example.petshop.Controller;
import com.example.petshop.Model.Product;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *  This class manages the http requests for the product model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class ProductController
{
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<Product>
     *
     *  This method executes a get request and returns all available Product
     */
    @GetMapping("/getProduct")
    public List<Product> all() {
        return repository.findAll();
    }

    /**
     *
     * @param newProduct
     * @return Product
     *
     *  This method executes a post request and creates a new Product
     */
    @PostMapping("/createProduct")
    public Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    /**
     *
     * @param id
     *
     *  This method executes a delete request and deletes an existing Product
     */
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * * @param newProduct
     * @return Product
     *
     *  This method executes an update request and updates an existing Product
     */
    @PutMapping("/putProduct")
    public Product updateProduct(@RequestBody Product newProduct){return repository.save(newProduct);}
}