package com.example.petshop.Controller;

import com.example.petshop.Model.OrderDetail;
import com.example.petshop.Repository.OrderDetailRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This class manages the http requests for the OrderDetail model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class OrderDetailController {
    private final OrderDetailRepository repository;

    public OrderDetailController(OrderDetailRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @return List<OrderDetail>
     *
     *  This method executes a get request and returns all available Order Details
     */
    @GetMapping("/getOrderDetail")
    public List<OrderDetail> all() {
        return repository.findAll();
    }

    /**
     *
     * @param newOrderDetail OrderDetail
     * @return OrderDetail
     *
     *  This method executes a post request and creates a new Order Detail
     */
    @PostMapping("/createOrderDetail")
    public OrderDetail newCart(@RequestBody OrderDetail newOrderDetail) {
        return repository.save(newOrderDetail);
    }

    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing Order Detail
     */
    @DeleteMapping("/deleteOrderDetail")
    public void deleteOrderDetail(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newOrderDetail OrderDetail
     * @return OrderDetail
     *
     *  This method executes an update request and updates an existing Order Detail
     */
    @PutMapping("/putOrderDetail")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail newOrderDetail){return repository.save(newOrderDetail);}
}
