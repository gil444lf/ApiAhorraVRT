package com.ahorraVrt.ahorrovirtual.model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.ArrayList;

@Data
@EqualsAndHashCode
public class Administrador extends Usuario {
    private String departamento;
    private List <Cliente> clientesAsignados;

    public Administrador() {}

    public Administrador(String id, String nombre, String email, String departamento) {
        super(id, nombre, email);
        this.departamento = departamento;
        this.clientesAsignados = new ArrayList<>();
    }

    public void revisarCuentas(){
        System.out.println(nombre + " está revisando las cuentas de los cientes.");
    }

    public Reporte generarReporte(String titulo){
        String contenido = "REPORTE GENERADO POR EL ADMINISTRADOR " + this.nombre + " DEL DEPARTAMENTO DE " + this.departamento + ".CLIENTES GESTIONADOS: " +this.clientesAsignados.size();

        Reporte nuevoReporte = new Reporte(titulo,contenido);
        System.out.println("REPORTE GENERADO: " +titulo);

        return nuevoReporte;
    }
    public void agregarCliente(Cliente cliente){
        this.clientesAsignados.add(cliente);
    }
}
