package com.example.observabilityspringgrafana.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
}
