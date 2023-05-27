package com.example.petshop.Controller;

import com.example.petshop.Model.User;
import com.example.petshop.Model.response.FetchEntities;
import com.example.petshop.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This class manages the http requests for the user model. It can add, delete, update and get the existing values in the table
 */

@RestController
public class UserController {
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<User>
     *
     *  This method executes a get request and returns all available Users
     */
    @GetMapping("/getUser")
    public ResponseEntity<FetchEntities<User>> all() {
        FetchEntities<User> fetchEntities = new FetchEntities<>();
        fetchEntities.setFetched(repository.findAll());
        return new ResponseEntity<>(fetchEntities, HttpStatus.OK);
    }

    /**
     *
     * @param newUser User
     * @return User
     *
     *  This method executes a post request and creates a new User
     */
    @PostMapping("/createUser")
    public User newUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing User
     */
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newUser User
     * @return User
     *
     *  This method executes an update request and updates an existing User
     */
    @PutMapping("/putUser")
    public User updateUser(@RequestBody User newUser){return repository.save(newUser);}
}
