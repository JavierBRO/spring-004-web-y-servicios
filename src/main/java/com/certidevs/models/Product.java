package com.certidevs.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // constructor todos parámetros
@NoArgsConstructor // constructor vacío
@Builder  // construir objetos de forma dinámica usando métodos encadenados más método .build()
public class Product {

    // atributos
    private Long id;
    private String title;
    private Double price;
    private ProductType type; // enum, agrupación de valores constantes
    private Boolean available;

    // constructor

    // getter y setter

    // toString

    // equals y hashCode




}
