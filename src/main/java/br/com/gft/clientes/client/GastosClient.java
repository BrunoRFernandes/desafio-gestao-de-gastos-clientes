package br.com.gft.clientes.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gft.clientes.dto.GastoDTO;
import br.com.gft.clientes.model.Gasto;

@FeignClient("gastos")
public interface GastosClient {
	
	@RequestMapping("/gastos/listarPorCliente/{id}")
	List<Gasto> listaPorCliente(@PathVariable Long id);
}
