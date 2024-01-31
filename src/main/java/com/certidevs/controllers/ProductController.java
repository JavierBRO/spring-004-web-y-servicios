package com.certidevs.controllers;

import com.certidevs.models.Product;
import com.certidevs.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// se hace la inyeccion de dependencia así@AllArgsConstructor
// crea la inyeccion de objetos el propio Spring Boot
@AllArgsConstructor
@RestController
public class ProductController {
    // Atributos
    private ProductService productService;

    // Constructores


//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }  CON EL CONSTRUCTOR SE INYECTA IGUAL O CON EL @AllArgsConstructor

    // métodos
    @GetMapping("products")
    public List<Product> findAllProducts(){
       // NO HACER A MANO aunque funcionaría...se haría con @AllArgsConstructor
        // productService = new ProductService();
        return productService.findAll();


    }
}
