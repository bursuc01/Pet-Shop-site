package com.example.petshop.Controller;

import com.example.petshop.Model.Product;
import com.example.petshop.Model.User;
import com.example.petshop.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getUser")
    public List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/createUser")
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody int id) {
        repository.deleteById(id);
    }

    @PutMapping("/putUser")
    public User updateUser(@RequestBody User newUser){return repository.save(newUser);}
}
