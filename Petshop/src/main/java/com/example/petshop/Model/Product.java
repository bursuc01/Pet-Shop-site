package com.example.petshop.Model;
import com.example.petshop.Observer.CustomObserver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Observable;

@Entity
@Table(name = "Product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements CustomObserver {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Override
    public void update(Object arg) {
        if (arg instanceof Integer) {
            int qty = (Integer) arg;
            if (this.quantity > qty)
                this.quantity -= qty;
            else
                this.quantity = 0;
        }

    }
}
