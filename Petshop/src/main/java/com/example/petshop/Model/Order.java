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
public class Order {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(name = "date")
    private String date;

    @Column(name = "details")
    private String details;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "client_id")
    private int client_id;


}
