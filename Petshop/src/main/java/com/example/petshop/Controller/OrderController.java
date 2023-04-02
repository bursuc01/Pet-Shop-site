package com.example.petshop.Controller;

import com.example.petshop.Model.Order;
import com.example.petshop.Repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

//    @RequestMapping("/addToOrder")
//    public void addToOrder(@RequestBody int id){}

    @GetMapping("/getOrder")
    public List<Order> all() {
        return repository.findAll();
    }

    @PostMapping("/createOrder")
    public Order newUser(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }

    @DeleteMapping("/deleteOrder")
    public void deleteUser(@RequestBody int id) {
        repository.deleteById(id);
    }

    @PutMapping("/putOrder")
    public Order updateUser(@RequestBody Order newOrder){return repository.save(newOrder);}
}
