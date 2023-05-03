package com.example.petshop.Controller;

import com.example.petshop.Repository.CartRepository;
import org.springframework.web.bind.annotation.*;
import com.example.petshop.Model.Cart;

import java.util.List;

/**
 *  This class manages the http requests for the cart model. It can add, delete, update and get the existing values in the table
 */
@RestController
public class CartController {
    private final CartRepository repository;

    public CartController(CartRepository cartRepository) {
        this.repository = cartRepository;
    }

    /**
     *
     * @return List<Cart>
     *
     *  This method executes a get request and returns all available Carts
     */
    @GetMapping("/getCart")
    public List<Cart> all() {
        return repository.findAll();
    }

    /**
     *
     * @param newCart
     * @return Cart
     *
     *  This method executes a post request and creates a new Cart
     */
    @PostMapping("/createCart")
    public Cart newCart(@RequestBody Cart newCart) {
        return repository.save(newCart);
    }

    /**
     *
     * @param id
     *
     * This method executes a delete request and deletes an existing Cart
     */
    @DeleteMapping("/deleteCart")
    public void deleteCart(@RequestBody int id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param newCart
     * @return Cart
     *
     *  This method executes an update request and updates an existing Cart
     */
    @PutMapping("/putCart")
    public Cart updateCart(@RequestBody Cart newCart){return repository.save(newCart);}
}
