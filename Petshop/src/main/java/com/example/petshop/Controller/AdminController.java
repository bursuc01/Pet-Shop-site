package com.example.petshop.Controller;

import com.example.petshop.Model.Admin;
import com.example.petshop.Repository.AdminRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This class manages the http requests for the admin model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class AdminController {
    private final AdminRepository repository;

    public AdminController(AdminRepository repository) {
        this.repository = repository;
    }


    /**
     *
     * @return List<Admin>
     *
     *  This method executes a get request and returns all available Admins
     */
    @GetMapping("/getAdmin")
    public List<Admin> all() {
        return repository.findAll();
    }


    /**
     *
     * @param newAdmin
     * @return Admin
     *
     *  This method executes a post request and creates a new Admin
     */
    @PostMapping("/createAdmin")
    public Admin newAdmin(@RequestBody Admin newAdmin) {
        return repository.save(newAdmin);
    }


    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing Admin
     */
    @DeleteMapping("/deleteAdmin")
    public void deleteAdmin(@RequestBody int id) {
        repository.deleteById(id);
    }


    /**
     *
     * @param newAdmin
     * @return Admin
     *
     *  This method executes an update request and updates an existing Admin
     */
    @PutMapping("/putAdmin")
    public Admin updateAdmin(@RequestBody Admin newAdmin){return repository.save(newAdmin);}
}
