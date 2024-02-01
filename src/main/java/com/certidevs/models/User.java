package com.certidevs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Clase user con anotaciones Lombok que autogeneran los métodos constructores
 * getter, setter,....PTE COMENTARIOS DE ALAN en VSCode
 */

@Data
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    // Dato sensible...como ignorarlo en respuestas json. Para no enviarlo en petición
    @JsonIgnore  //  para ocultar datos sensibles atributo password lo ignora p.ej.
    // @JsonIgnoreProperties es vital para ignorar atributos en asociaciones .
    private String password;



}
