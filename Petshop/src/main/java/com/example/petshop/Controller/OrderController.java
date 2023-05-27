package com.example.petshop.Controller;

import com.example.petshop.Model.Order;
import com.example.petshop.Model.Product;
import com.example.petshop.Repository.OrderRepository;
import com.example.petshop.Repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class manages the http requests for the order model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class OrderController {
    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private Order order;

    public OrderController(OrderRepository repository, ProductRepository productRepository) {
        this.repository = repository;
        this.productRepository = productRepository;
    }

    /**
     *
     * @param id
     *
     *  This method takes the id of the requested item and adds it to an existing order by providing order id
     */
    @RequestMapping("/addToOrder")
    public void addToOrder(@RequestBody int id, int idOrder) {
        if(repository.findById(idOrder).isPresent())
            order = repository.findById(idOrder).get();
        if (productRepository.findById(id).isPresent()) {
            Order ord = order.addProduct(order.getOrderQuantity(), productRepository.findById(id).get());
            Product product = productRepository.findById(id).get();
            if(product.getQuantity() > order.getOrderQuantity()){
                product.setQuantity(productRepository.findById(id).get().getQuantity()-order.getOrderQuantity());
                order.getItems().put(order.getOrderQuantity(),product);
                System.out.println("Items:");
                System.out.println(order.getItems().get(order.getOrderQuantity()).getDescription());
            }
            else
                if(product.getQuantity() == order.getOrderQuantity()) {
                    product.setQuantity(0);
                    order.getItems().put(order.getOrderQuantity(),product);
                }
                else
                    System.out.println("Order not valid because quantity not available");
            repository.save(ord);
        }
    }
    /**
     *
     * @return List<Order>
     *
     *  This method executes a get request and returns all available Orders
     */
    @GetMapping("/getOrder")
    public List<Order> all() {
        return repository.findAll();
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
