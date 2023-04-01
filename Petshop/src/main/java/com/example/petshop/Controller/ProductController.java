package com.example.petshop.Controller;
import com.example.petshop.Model.Product;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String hello()
    {
        return "Hello";
    }

    @GetMapping("/getProduct")
    public List<Product> all() {
        return repository.findAll();
    }

    @PostMapping("/createProduct")
    public Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody int id) {
        repository.deleteById(id);
    }

    @PutMapping("/putProduct")
    public Product updateProduct(@RequestBody Product newProduct){return repository.save(newProduct);}
}