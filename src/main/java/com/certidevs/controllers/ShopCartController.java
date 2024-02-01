package com.certidevs.controllers;

import com.certidevs.models.ShopCartHasProductsDTO;
import com.certidevs.models.ShopCartPrice;
import com.certidevs.models.User;
import com.certidevs.services.ProductService;
import com.certidevs.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor  // Viene de Lombok
@RestController  // viene de Spring
public class ShopCartController { //ShopCartTotalPrice

    private ProductService productService;
    private UserService userService;

    @GetMapping("calculate-total-price")
    public Double getCurrentTotalPrice() {

    return productService.calculateTotalPrice();

    }
    @GetMapping("calculate-total-price2")
    public ResponseEntity<Double> getCurrentTotalPrice2() {

        Double price = productService.calculateTotalPrice();
        return ResponseEntity.ok(price);

    }
    @GetMapping("calculate-total-price3")
    public ShopCartPrice getCurrentTotalPrice3() {

        Double price = productService.calculateTotalPrice();
        return new ShopCartPrice(price);
        // aquí ya se devuelve en el get un json del precio, un objeto
        // ...no un simple número double como en los dos casos anteriores
    }
    // crear método que devuelva un objeto  json que diga si hay productos
    // En el listado del servicio aparezca true or false dentro del objeto json
    /*
    {
    "existProducts :true"  para los dto se crean records mejor
    }
    posibles nombres para el DTO: Data Transfer Object
    ProductExistenceDTO
    ShopCartNotEmpty
    ShopCartHasProducts
     */
//    @GetMapping("shopcart-has-products")
//
//    public Boolean checkShopCartHasProduct() {
//
//        Boolean exist = productService.checkShopCartHasProduct();
//        return exist;  // true porque hay objetos. y si queremos que nos lo devuelva como un objeto json
//    }

    @GetMapping("shopcart-has-products")

    public ShopCartHasProductsDTO checkShopCartHasProduct() {

        Boolean exist = productService.checkShopCartHasProduct();
        return new ShopCartHasProductsDTO(exist);
    }
    // Desde este mismo controlador se conecta a otro servicio. el UserService.
    // ..Los servicios van inyectando en los controladores, y no dependencias circulares no entre modelos.
    // La inyeccion de dependencias las realiza Spring....lombok solo crea constructores y demás con anotacion
    @GetMapping("shopcart-user/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
