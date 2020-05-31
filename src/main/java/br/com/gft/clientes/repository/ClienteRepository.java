package br.com.gft.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
