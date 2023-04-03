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
            order.addProduct(order.getOrderQuantity(), productRepository.findById(id).get());
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
            productRepository.save(product);
        }
    }

    /**
     *
     * @return
     *
     *  This method executes a get request and returns all available Orders
     */
    @GetMapping("/getOrder")
    public List<Order> all() {
        return repository.findAll();
    }

    /**
     *
     * @param newOrder
     * @return
     *
     *  This method executes a post request and creates a new Order
     */
    @PostMapping("/createOrder")
    public Order newUser(@RequestBody Order newOrder) {
        return repository.save(newOrder);
    }

    /**
     *
     * @param id
     *
     *  This method executes a delete request and deletes an existing Order
     */
    @DeleteMapping("/deleteOrder")
    public void deleteUser(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newOrder
     * @return
     *
     *  This method executes an update request and updates an existing Order
     */
    @PutMapping("/putOrder")
    public Order updateUser(@RequestBody Order newOrder){return repository.save(newOrder);}
}
