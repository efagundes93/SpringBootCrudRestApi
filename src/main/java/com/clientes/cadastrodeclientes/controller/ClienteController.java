package com.clientes.cadastrodeclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.clientes.cadastrodeclientes.model.Cliente;
import com.clientes.cadastrodeclientes.service.CadastroClientesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="clientes", description="Cadastro de clientes")
public class ClienteController {
	
	@Autowired
	CadastroClientesService cadastroClientesService;
	
	@ApiOperation(value = "Disponibiliza a lista de cadastros de clientes",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista obtida com sucesso"),
            @ApiResponse(code = 401, message = "Você não tem acesso a esta funcionalidade"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Recurso não encontrado")
    }
    )
	@RequestMapping(method=RequestMethod.GET, value="/clientes")
    public Iterable<Cliente> client() {
        return cadastroClientesService.getCadastros();      
    }
	
	 @RequestMapping(method=RequestMethod.POST, value="/clientes")
	    public String save(@RequestBody Cliente  cliente) {
		      return cadastroClientesService.createCliente(cliente);
	    }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/clientes/{id}")
	    public Cliente  show(@PathVariable String id) {
	        return   cadastroClientesService.getOne(id);
	    }
	 
	 @RequestMapping(method=RequestMethod.PUT, value="/clientes/{id}")
	    public Cliente update(@PathVariable String id, @RequestBody Cliente cliente) {
	        return cadastroClientesService.updateCadastro(id, cliente);
	    }
	 
	 @RequestMapping(method=RequestMethod.DELETE, value="/clientes/{id}")
	    public String delete(@PathVariable String id) {
	        return  cadastroClientesService.deleteCadastro(id);
	    }
}