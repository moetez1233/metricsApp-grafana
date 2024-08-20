package com.example.observabilityspringgrafana.controller;

import com.example.observabilityspringgrafana.entities.Product;
import com.example.observabilityspringgrafana.modeles.Post;
import com.example.observabilityspringgrafana.repositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductRespository productRespository;

    private RestClient restClient;

    public ProductController(RestClient.Builder restClient){
        this.restClient=restClient.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRespository.findAll();
    }
    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        List<Post> posts=restClient.get().uri("/posts").retrieve().body(new ParameterizedTypeReference<List<Post>>() {
        });
        System.out.println("posts0: "+posts.get(0));
        return posts;

    };
}
