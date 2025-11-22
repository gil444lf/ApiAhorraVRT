package com.ahorraVrt.ahorrovirtual.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Reporte {
    private String titulo;
    private String contenido;
    private LocalDateTime fechaGeneracion;

    public Reporte(String titulo, String contenido){
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaGeneracion = LocalDateTime.now();
    }
}
