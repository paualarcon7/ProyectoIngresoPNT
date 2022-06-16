package com.dosideas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//entity indica que esta clase está asociada a la tabla en la base de datos

@Entity
public class Provincia {
    
    @Id //el atributo es la primary key en la BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de generación de este id
    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
