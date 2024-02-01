package com.certidevs.services;

import com.certidevs.models.Product;
import com.certidevs.models.ProductType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// @AllArgsConstructor  NO Usar lombok porque ya creamos.
// un constructor con datos demo. EVITAR REFERENCIAS CIRCULARES entre servicios
@Service
public class ProductService {

    private List<Product> products;
    private UserService userService;


    public ProductService (UserService userService) {  //3 formas distintas de crear objetos 1:
        this.userService = userService;
        // comprobar que userService esta correctamente inyectado en productService
        this.userService.findById(1L);
        System.out.println("UserService inyectado perfectamente en ProcuctService");

        products = new ArrayList<>();

        products.add(Product.builder()
                .id(1L)
                .price(30.0)
                .title("Product 1")
                .type(ProductType.LAPTOP)
                .available(true)
                .build()
        );
        // 2:
        Product product2 = new Product(2L, "Product 2", 30.5, ProductType.MONITOR, true);

        products.add(product2);

        // 3:
        Product product3 = new Product();
        product3.setId(3L);
        product3.setTitle("Product 3");
        product3.setPrice(40.3);
        product3.setTitle("Product 3");
        product3.setType(ProductType.MONITOR);
        product3.setAvailable(false);

        products.add(product3);
    }

    public List<Product> findAll() {
        return new ArrayList<>(products);  // crea una copia del arrayList productos
    }

    public Double calculateTotalPrice() {
        // se lo hemos puesto fijo el double 100 como prueba para que lo devuelva..sin calcularlo con for
        return 100d;
    }

    public Boolean checkShopCartHasProduct() {
        // return this.product.size() > 0
        return !this.products.isEmpty();
    }
}