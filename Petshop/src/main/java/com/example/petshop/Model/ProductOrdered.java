package com.example.petshop.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ProductOrdered")
@NoArgsConstructor
@Getter
@Setter
public class ProductOrdered{
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productOrdered_id;

    @Column(name = "quantity")
    private int ordered_quantity;

    @Column(name = "order_id")
    private int order_id;

    @Column(name = "product_id")
    private int product_id;

    public ProductOrdered(int ordered_quantity, int order_id, int product_id) {
        this.ordered_quantity = ordered_quantity;
        this.order_id = order_id;
        this.product_id = product_id;
    }
}
