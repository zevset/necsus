package mx.com.necsus.clientes.api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.necsus.clientes.api.entity.Client;
import mx.com.necsus.clientes.api.repository.ClientRepository;

@Service
public class ClientService implements IClientService{

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
    protected ClientRepository clientRepository;
	
	@Override
	public Client registerClient(Client client) {
		LOGGER.info("Entro al servicio");
		return clientRepository.save(client);
	}

	@Override
	public Client getClientById(int idClient) {
		LOGGER.info("Entro al servicio: getClientById");
		Optional<Client> response =clientRepository.findById(idClient);
		if(response.isEmpty())
			return null;
			
		return response.get();
	}

	@Override
	public List<Client> listAllClients() {
		LOGGER.info("Entro al servicio");
		return clientRepository.findAll();
	}

	@Override
	public Client updateClient(int idClient, String name, String email) {
		LOGGER.info("Entro al servicio: updateClient");
		Client client = this.getClientById(idClient);
		LOGGER.info("Cliente {}",client);
		client.setEmail(email);
		client.setName(name);
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(int idClient) {
		LOGGER.info("Entro al servicio");
		clientRepository.deleteById(idClient);
	}

}
