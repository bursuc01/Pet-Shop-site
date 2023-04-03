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
    private Integer id;

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

    /**
     *
     * @param qty
     * @param product
     *
     *  This is a method that lets you add a product to the order by modifying quantity in the
     *  product itself and putting the product in the Map attribute of the Order class.
     */
    public void addProduct(int qty, Product product){
        if(product.getQuantity() > qty){
            System.out.println("I am here2 :" + qty);
            this.items.put(qty, product);
            System.out.println(items.get(qty).getId());
            registerObserver(product);
            notifyObservers(qty);
        }
    }

}
