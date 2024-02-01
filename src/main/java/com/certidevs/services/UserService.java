package com.certidevs.services;

import com.certidevs.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Javadoc
 * Clase de operaciones para trabajar con objetos tipo User
 * Principalmente métodos CRUD
 *
 */
@AllArgsConstructor
@Service
public class UserService {
    // TODO: Inyectar el productService
//  COMENTADO PARA EVITAR LA REFERENCIA CIRCULAR
// Ya se inyecta userService en ProductService
//    private ProductService productService;


    /**
     * Método ficticio que simula tener un usuario de base de datos
     * utilizando como filtro su clave primaria que es el id.
     *
     * @param id clave primaria tipo Long
     * @return Objeto de la clase User ficticio Hard-coded
     */
    public User findById(Long id) {
////        System.out.println(productService.checkShopCartHasProduct()); // devuelve un booleano true en consola.
////         ..funciona con el postman al repetir el get de antes. Pero con el método del servicio productService
////         OBJETIVO : Comprobar que productService no sea nulo, porque se ha inyectado bien.
//        if (productService == null)
////            System.out.println("HAY un ERROR");
////        else System.out.println("ok");
    return new User(id, "usuario1", "U1@gmail.com", "admin");
    }

}
