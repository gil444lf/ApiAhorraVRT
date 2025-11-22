package com.ahorraVrt.ahorrovirtual.controller;

import com.ahorraVrt.ahorrovirtual.dto.MetaAhorroRequest;
import com.ahorraVrt.ahorrovirtual.model.Cliente;
import com.ahorraVrt.ahorrovirtual.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BaseMultiResolutionImage;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/banco")
public class BancoController {

    private final BancoService bancoService;

    @Autowired
    public BancoController(BancoService bancoService){
        this.bancoService = bancoService;
    }
    //---Endpoint 1: Obtener todos los clientes---
    //GET: http://localhost8080/api/banco/clientes

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerClientes(){
        List<Cliente> clientes = bancoService.obtenerTodosLosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    //---Endpoint 2: Obtener clientes por su id---
    //GET: http://localhost8080/api/banco/clientes/C001

    @GetMapping("/clientes/{id}")

    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable String id){
        Optional<Cliente> cliente = bancoService.buscarClientePorId(id);

        return cliente.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    //--- Endpoint 3: Realizar depósito ---
    //POST: http://localhost8080/api/banco/transaccion/deposito
    /*
    Cuerpo JSON (Body):

    {
        "clienteId": "C001",
        "numeroCuenta": "CTA123",
        "cantidad": 500.00
    }
    */
@PostMapping("/transaccion/deposito")
public ResponseEntity<?> depositar(@RequestBody Map<String, Object> requestBody){
try{
    String clienteId = (String) requestBody.get("clienteId");
    String numeroCuenta = (String) requestBody.get("numeroCuenta");
    Double cantidad = Double.parseDouble(requestBody.get("cantidad").toString());

    if(bancoService.realizarDeposito(clienteId, numeroCuenta, cantidad)){
        return new ResponseEntity<>("Deposito realizado con exito", HttpStatus.OK);
    }else{
        return new ResponseEntity<>("Error: Cliente o Cuenta no encontrados", HttpStatus.NOT_FOUND);
    }

}catch (Exception e){
    return new ResponseEntity<>("Error en el formato de la solicitud: " + e.getMessage(), HttpStatus.BAD_REQUEST);
}
}
//---ENDPOINT 4: Agregar meta de Ahorro (POST)---
    //POST:  http://localhost:8080/api/banco/clientes/{id}/metas
    @PostMapping("/clientes/{clienteId}/metas")
    public ResponseEntity<?> agregarMeta(@PathVariable String clienteId, @RequestBody MetaAhorroRequest request){

    if(request.getNombreMeta()==null||request.getObjetivo()<=0){
        return new ResponseEntity<>("NOMBRE DE META U OBJETIVO INVÁLIDO.",HttpStatus.BAD_REQUEST);
    }
    if(bancoService.agregarMetaAhorro(clienteId,request.getNombreMeta(), request.getObjetivo())){
        return new ResponseEntity<>("META DE AHORRO " + request.getNombreMeta() + " AGREGADA CON ÉXITO.",HttpStatus.CREATED);
    }else{
        return new ResponseEntity<>("CLIENTE CON ID " + clienteId + " NO ENCONTRADO.",HttpStatus.NOT_FOUND);
    }
    }
}
