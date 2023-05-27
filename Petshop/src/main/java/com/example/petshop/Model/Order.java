package com.example.petshop.Model;

import com.example.petshop.Observer.Update;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order extends Update {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(name = "date")
    private String date;

    @Column(name = "details")
    private String details;

    @Column(name = "orderQuantity")
    private int orderQuantity;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Map<Integer, Product> items = new TreeMap<>();

    public Order(String date, String details, int orderQuantity, Map<Integer, Product> items) {
        this.date = date;
        this.details = details;
        this.orderQuantity = orderQuantity;
        this.items = items;
    }

    /**
     *
     * @param qty
     * @param product
     *
     *  This is a method that lets you add a product to the order by modifying quantity in the
     *  product itself and putting the product in the Map attribute of the Order class.
     */
    public Order addProduct(int qty, Product product){
        if(product.getQuantity() > qty){
            System.out.println("I am here2 :" + qty);
            this.items.put(product.getProduct_id(), product);
            System.out.println(items.get(qty).getProduct_id());
            registerObserver(product);
            notifyObservers(qty);
            return new Order(this.date, this.details, this.orderQuantity, this.items);
        }
        else
            return new Order(this.date, this.details, this.orderQuantity, this.items);
    }

}
