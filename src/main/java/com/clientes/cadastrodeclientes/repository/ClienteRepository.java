package com.clientes.cadastrodeclientes.repository;

import org.springframework.data.repository.CrudRepository;

import com.clientes.cadastrodeclientes.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
   @Override
    void delete(Cliente deleted);
   
}