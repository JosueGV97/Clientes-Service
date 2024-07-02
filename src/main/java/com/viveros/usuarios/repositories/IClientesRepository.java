package com.viveros.usuarios.repositories;

import com.viveros.usuarios.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientesRepository extends JpaRepository<Clientes, Long> {

}
