package com.ahorraVrt.ahorrovirtual.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Transaccion {
    private String tipo;
    private double monto;
    private LocalDateTime fecha;

    public Transaccion() {
        this.fecha = LocalDateTime.now();
    }

    public Transaccion(String tipo, double monto){
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }
}
