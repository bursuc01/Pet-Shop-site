package com.example.petshop.Repository;
import com.example.petshop.Model.ProductOrdered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderedRepository extends JpaRepository<ProductOrdered, Integer> {

}