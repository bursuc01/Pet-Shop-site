package com.example.petshop;
import org.springframework.data.jpa.repository.JpaRepository;

interface Repository extends JpaRepository<Product, Long> {

}