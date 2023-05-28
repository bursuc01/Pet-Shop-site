package com.example.petshop.Controller;

import com.example.petshop.Model.Order;
import com.example.petshop.Model.Product;
import com.example.petshop.Model.response.FetchEntities;
import com.example.petshop.Repository.OrderRepository;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class manages the http requests for the order model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<Order>
     *
     *  This method executes a get request and returns all available Orders
     */
    @GetMapping("/getOrder")
    public ResponseEntity<FetchEntities<Order>> all() {
        FetchEntities<Order> fetchEntities = new FetchEntities<>();
        fetchEntities.setFetched(repository.findAll());
        return new ResponseEntity<>(fetchEntities, HttpStatus.OK);
    }

    /**
     *
     * @param newOrder Order
     * @return Order
     *
     *  This method executes a post request and creates a new Order
     */
    @PostMapping("/createOrder")
    public Order newOrder(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }

    /**
     *
     * @param id
     *
     *  This method executes a delete request and deletes an existing Order
     */
    @DeleteMapping("/deleteOrder")
    public void deleteOrder(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newOrder Order
     * @return Order
     *
     *  This method executes an update request and updates an existing Order
     */
    @PutMapping("/putOrder")
    public Order updateOrder(@RequestBody Order newOrder){return repository.save(newOrder);}
}
