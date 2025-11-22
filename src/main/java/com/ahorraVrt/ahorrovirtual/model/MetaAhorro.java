package com.ahorraVrt.ahorrovirtual.model;
import lombok.Data;

@Data
public class MetaAhorro {
    private String nombreMeta;
    private double objetivo;
    private double montoActual;

    public MetaAhorro() {}

    public MetaAhorro(String nombreMeta, double objetivo){
        this.nombreMeta = nombreMeta;
        this.objetivo = objetivo;
        this.montoActual = 0;
    }

    public void ahorrar(double cantidad){
        montoActual += cantidad;
    }

    public double getProgreso(){
        return(montoActual / objetivo) * 100;
    }
}
