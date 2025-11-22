package com.ahorraVrt.ahorrovirtual.model;
import lombok.Data;

@Data
public class Recompensa {
    private String descripcion;

    public Recompensa() {}

    public Recompensa(String descripcion) {
        this.descripcion = descripcion;
    }
}
