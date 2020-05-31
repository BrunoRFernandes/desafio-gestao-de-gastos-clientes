package br.com.gft.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.clientes.client.GastosClient;
import br.com.gft.clientes.dto.ClienteDTO;
import br.com.gft.clientes.dto.GastoDTO;
import br.com.gft.clientes.model.Cliente;
import br.com.gft.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private GastosClient gastosClient;
	
	public Cliente setCliente(ClienteDTO cliente) {
		
		Cliente novoCliente = new Cliente(
				cliente.getName(),
				cliente.getLogin(),
				cliente.getPassword(),
				cliente.getTipoUsuario()
		);
		
		clienteRepository.save(novoCliente);
		
		return novoCliente;
	}

	public List<Cliente> lista() {
		List<Cliente> listaGasto =  clienteRepository.findAll();
		
		return listaGasto;
	}
	
	public List<GastoDTO> listaGastos(Long id) {
	
		List<GastoDTO> list = gastosClient.listaPorCLiente(id);
		
		return list;
	}
	
}
