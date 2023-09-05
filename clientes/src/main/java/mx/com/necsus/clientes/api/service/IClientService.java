package mx.com.necsus.clientes.api.service;

import java.util.List;
import mx.com.necsus.clientes.api.entity.Client;


public interface IClientService {
	
	Client registerClient(Client client);
	Client getClientById(int idClient);
	List<Client> listAllClients();
	Client updateClient( int idClient, String name, String email);
	void deleteClient(int idClient);

}
