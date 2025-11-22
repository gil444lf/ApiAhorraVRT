package com.ahorraVrt.ahorrovirtual.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Notificacion {
    private String mensaje;
    private String tipo;

    private LocalDateTime fechaEnvio;

    public Notificacion(String mensaje, String tipo){
        this.mensaje = mensaje;
        this.tipo = tipo;
        this.fechaEnvio = LocalDateTime.now();
    }
}
