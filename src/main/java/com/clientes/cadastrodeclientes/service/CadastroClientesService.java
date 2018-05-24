package com.clientes.cadastrodeclientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientes.cadastrodeclientes.model.Cliente;
import com.clientes.cadastrodeclientes.repository.ClienteRepository;
import com.clientes.cadastrodeclientes.util.Validador;

@Service
public class CadastroClientesService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public String createCliente(Cliente cliente) {
		System.out.println(cliente.toString());
		if(Validador.isValidcpf(cliente.getCPF())) {
			return clienteRepository.save(cliente).getCPF();
		}
		return null;
	}

	public Iterable<Cliente> getCadastros() {
		return clienteRepository.findAll();
	}
	
	public Cliente updateCadastro(String cpf, Cliente cliente) {
		Cliente  newCliente  = clienteRepository.findById(cpf).orElse(null);
	    if(cliente.getNome() != null) {
	    	newCliente.setNome(cliente.getNome());
	    }
	    clienteRepository.save(newCliente);
	    return newCliente;
	}
	
	public Cliente getOne(String cpf) {		
	    return clienteRepository.findById(cpf).orElse(null);
	}
	
	public String deleteCadastro(String cpf) {
		Cliente  cliente  = clienteRepository.findById(cpf).orElse(null);
	 	clienteRepository.delete(cliente);
        return "client deleted";
	}
	

}
