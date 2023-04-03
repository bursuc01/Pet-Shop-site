package com.example.petshop.Model;
import com.example.petshop.Observer.CustomObserver;
import com.example.petshop.Repository.ProductRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    /**
     *
     * @param arg
     *
     *  This method works on the Observer design pattern, and updates the quantity of the object once it's added to
     *  an order.
     */
    @Override
    public void update(Object arg) {
        System.out.println("I am here 4");
        if (arg instanceof Integer) {
            System.out.println("I am here 5");
            int qty = (Integer) arg;
            System.out.println(qty);
        }
    }
}
