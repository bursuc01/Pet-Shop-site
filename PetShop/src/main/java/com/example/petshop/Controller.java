package com.example.petshop;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public String hello()
    {
        return "Hello Dmitrea";
    }

    @GetMapping("/get")
    public List<Product> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    public Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteProduct(@PathVariable long id) {
        repository.deleteById(id);
    }
}