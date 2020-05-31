package br.com.gft.clientes.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gft.clientes.client.GastosClient;
import br.com.gft.clientes.dto.ClienteDTO;
import br.com.gft.clientes.dto.GastoDTO;
import br.com.gft.clientes.model.Cliente;
import br.com.gft.clientes.repository.ClienteRepository;

@Service
public class ClienteService {
	
	Logger logger = LoggerFactory.getLogger(ClienteService.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private GastosClient gastosClient;
	
	public Cliente setCliente(ClienteDTO cliente) {
		
		try {
			Cliente novoCliente = new Cliente(
					cliente.getName(),
					cliente.getLogin(),
					cliente.getPassword(),
					cliente.getTipoUsuario()
			);
			
			logger.info("Cliente cadastrado com sucesso.");
			clienteRepository.save(novoCliente);
			return novoCliente;
			
		} catch (Exception exceptionCliente) {
			logger.error("Error: " + exceptionCliente.getMessage());
			return null;
		}
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
