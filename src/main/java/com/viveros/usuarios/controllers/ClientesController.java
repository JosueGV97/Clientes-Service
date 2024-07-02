package com.viveros.usuarios.controllers;

import com.viveros.usuarios.models.Clientes;
import com.viveros.usuarios.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {
    @Autowired
    ClientesService clientesService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Clientes c){
        Clientes cliente = clientesService.save(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> gettAll(){
        List<Clientes> clientes = clientesService.selectAll();
        if(clientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(clientes);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        Optional<Clientes> cliente = clientesService.selectById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        Optional<Clientes> cliente = clientesService.selectById(id);
        if(cliente.isPresent()){
            clientesService.delete(cliente.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> put(@RequestBody Clientes c, @PathVariable(name = "id") Long id){
        Optional<Clientes> cliente = clientesService.selectById(id);
        if(cliente.isPresent()){
            c.setPkCliente(id);
            clientesService.save(c);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
