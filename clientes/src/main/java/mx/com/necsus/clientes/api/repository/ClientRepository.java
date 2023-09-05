package mx.com.necsus.clientes.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.necsus.clientes.api.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
}

