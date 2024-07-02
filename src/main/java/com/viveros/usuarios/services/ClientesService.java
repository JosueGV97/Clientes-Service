package com.viveros.usuarios.services;

import com.viveros.usuarios.models.Clientes;
import com.viveros.usuarios.repositories.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("clientesService")
public class ClientesService {
    @Autowired
    private IClientesRepository clientesRepository;

    public List<Clientes> selectAll(){
        List<Clientes> clientes = new ArrayList<>();
        clientes = this.clientesRepository.findAll();
        return clientes;
    }

    public Optional<Clientes> selectById(Long id){
        Optional<Clientes> cliente = this.clientesRepository.findById(id);
        if(cliente.isPresent()){
            return cliente;
        }
        return Optional.empty();
    }

    public Clientes save(Clientes c){
        return this.clientesRepository.save(c);
    }

    public void delete(Clientes c){
        this.clientesRepository.delete(c);
    }
}
