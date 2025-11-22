package com.ahorraVrt.ahorrovirtual.model;

import lombok.Data;

@Data
public class Usuario {
    protected String id;
    protected String nombre;
    protected String email;

    public Usuario() {}
    public Usuario(String id, String nombre, String email){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
}
