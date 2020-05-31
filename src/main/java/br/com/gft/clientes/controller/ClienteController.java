package br.com.gft.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.clientes.dto.ClienteDTO;
import br.com.gft.clientes.dto.GastoDTO;
import br.com.gft.clientes.model.Cliente;
import br.com.gft.clientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente novoCliente(@RequestBody ClienteDTO cliente) {
		return clienteService.setCliente(cliente);
	}
	
	@GetMapping("/listar")
	public List<Cliente> listaClientes(){
		return clienteService.lista();
	}
	
	@GetMapping("/listarGastos/{id}")
	public List<GastoDTO> listarPorCliente(@PathVariable Long id){
		return clienteService.listaGastos(id);
	}
}
