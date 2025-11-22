package com.ahorraVrt.ahorrovirtual.model;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente extends Usuario {
    private List<Cuenta> cuentas;
    private List<MetaAhorro> metas;
    private Recompensa recompensa;
    private List<Notificacion> notificaciones;

    public Cliente() {
        this.cuentas = new ArrayList<>();
        this.metas = new ArrayList<>();
        this.recompensa = new Recompensa("Sin recompensa aún");
    }

    public Cliente(String id, String nombre, String email) {
        super(id, nombre, email);
        this.cuentas = new ArrayList<>();
        this.metas = new ArrayList<>();
        this.recompensa = new Recompensa("Sin recompensa aún");
        this.notificaciones = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void agregarMeta(MetaAhorro meta) {
        metas.add(meta);
    }

    public double calcularSaldoTotal() {
        return
        cuentas.stream().mapToDouble(Cuenta::getSaldo).sum();

    }
}

