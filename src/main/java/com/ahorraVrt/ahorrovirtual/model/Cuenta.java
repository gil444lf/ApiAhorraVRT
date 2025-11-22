package com.ahorraVrt.ahorrovirtual.model;
import lombok.Data;

@Data
public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta(){}

    public Cuenta(String numeroCuenta, double saldo){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public void depositar(double cantidad){
        saldo += cantidad;
    }

    public void retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("Fondos Insuficientes");
        }
    }
}
