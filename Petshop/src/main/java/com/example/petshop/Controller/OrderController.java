package com.example.petshop.Controller;

import com.example.petshop.Model.Order;
import com.example.petshop.Model.Product;
import com.example.petshop.Repository.OrderRepository;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private Order order = new Order();

    public OrderController(OrderRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @RequestMapping("/addToOrder")
    public void addToOrder(@RequestBody int qty, int id) {
        if (productRepository.findById(id).isPresent())
            order.addProduct(qty, productRepository.findById(id).get());
    }

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
