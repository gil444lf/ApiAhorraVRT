package com.ahorraVrt.ahorrovirtual.service;

import com.ahorraVrt.ahorrovirtual.model.Cliente;
import com.ahorraVrt.ahorrovirtual.model.Cuenta;
import com.ahorraVrt.ahorrovirtual.model.MetaAhorro;
import  org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BancoService {
    //aca vamos a simular una "base de datos en memoria

    private final List<Cliente> clientes = new ArrayList<>();

    public BancoService() {
        //aca vamos a inicializar akgunos datos de prueba

        Cliente cliente1 = new Cliente("COO1", "Luis Villa", "luisvll45@gmail.com");
        cliente1.agregarCuenta(new Cuenta("CTA123", 5000));
        cliente1.agregarMeta(new MetaAhorro("Viaje a Europa", 10000));

        Cliente cliente2 = new Cliente("C002", "Ana Díaz", "anitad32@gmail.com");
        cliente2.agregarCuenta(new Cuenta("CTA456", 1200));

                clientes.add(cliente1);
                clientes.add(cliente2);
    }
    /**
     * Endpoint 1 : Obtener todos los clientes
     */

    public List<Cliente>
    obtenerTodosLosClientes() {
        return clientes;
    }
    /**
     * Enpoint 2: Buscar cliente por su ID
     */

    public Optional<Cliente>
    buscarClientePorId(String id){
        return clientes.stream().filter(cliente -> cliente.getId().equals(id)).findFirst();
    }
    /**
     * Endpoint 3: Realizar un depósito en una cuenta
     */

    public boolean realizarDeposito(String clienteId, String numeroCuenta, double cantidad){
        Optional<Cliente> optCliente = buscarClientePorId(clienteId);

        if(optCliente.isPresent()){
            Cliente cliente = optCliente.get();
            Optional<Cuenta> optCuenta = cliente.getCuentas().stream().filter(cuenta -> cuenta.getNumeroCuenta().equals(numeroCuenta)).findFirst();

            if(optCuenta.isPresent()){
                Cuenta cuenta = optCuenta.get();

                cuenta.depositar(cantidad);

                //Aqui se puede agregar una Transaccion al historial si se sigue la logica

                return true;
            }
        }
        return false;
    }
    /**
     * *LOGICA AGREGADA: Agregar una meta de Ahorro a un cliente
     */
    public boolean agregarMetaAhorro(String clienteId, String nombreMeta, double objetivo){
        Optional<Cliente> optCliente = buscarClientePorId(clienteId);

        if(optCliente.isPresent()){
            Cliente cliente = optCliente.get();

            MetaAhorro nuevaMeta = new MetaAhorro(nombreMeta, objetivo);

            cliente.agregarMeta(nuevaMeta);

            return true;
        }
        return false;
    }
}

