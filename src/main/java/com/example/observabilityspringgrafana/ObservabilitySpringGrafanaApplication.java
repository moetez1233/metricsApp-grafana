package com.example.observabilityspringgrafana;

import com.example.observabilityspringgrafana.entities.Product;
import com.example.observabilityspringgrafana.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner (ProductRespository productRespository) {

        return args ->{
            Product product=new Product();
            product.setName("Computer");
            product.setPrice(2300);

            Product product1=new Product();
            product1.setName("Smartphone");
            product1.setPrice(1200);

            Product product2=new Product();
            product2.setName("Printer");
            product2.setPrice(300);
            List<Product> productList= List.of(product1,product2,product);
            productRespository.saveAll(productList);
            productRespository.findAll().forEach(System.out::println);

        };
    };

}
