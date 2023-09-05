package mx.com.necsus.clientes.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import mx.com.necsus.clientes.api.entity.Client;
import mx.com.necsus.clientes.api.service.IClientService;

@RestController
@RequestMapping(value = "/necsus/client")
public class ClientAPI {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientAPI.class);
	
	@Autowired
	private IClientService service;

    @RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity createClient( @RequestBody Client client) {		
    	LOGGER.info("createClient");
    	LOGGER.info(client.getName()+" "+ client.getEmail());
    	client = service.registerClient(client);
    
    		LOGGER.info("Respuesta del servicio");
    	if(client.getIdClient() == 0)
    		return new ResponseEntity<>(new ResponseClient(null, false), HttpStatus.INTERNAL_SERVER_ERROR);
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("client", client.getIdClient());
    	response.put("sucess", true);
    	return new ResponseEntity<>(response, HttpStatus.OK);
	}

    @RequestMapping(value="", method=RequestMethod.GET)
    public ResponseEntity ListClients() {
    	LOGGER.info("ListClients");
    	List<Client> clients = service.listAllClients();
    	LOGGER.info("Respuesta del servicio");
    	Map<String, Object> response = new HashMap<>();
    	response.put("employees", clients);
    	response.put("sucess", true);
    	return new ResponseEntity<>(response, HttpStatus.OK);	
	}
    

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity getClient(@PathVariable Long id) {
    	LOGGER.info("getClient");
    	LOGGER.info("id {}", id);
    	Client employee = service.getClientById(id.intValue());
    	LOGGER.info("Respuesta del servicio");
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("employees", employee);
    	response.put("sucess", true);
    	return new ResponseEntity<>(response, HttpStatus.OK);
	}

    
    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
    	LOGGER.info("id", id);
    	LOGGER.info(client.getName()+" "+ client.getEmail());
    	client = service.updateClient(id.intValue(),client.getName(),client.getEmail());
    	LOGGER.info("Respuesta del servicio");
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("client", client);
    	response.put("sucess", true);
    	return new ResponseEntity<>(response, HttpStatus.OK);
	}
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity deleteClient(@PathVariable Long id) {
    	LOGGER.info("job_id {}", id);
    	service.deleteClient(id.intValue());
    	LOGGER.info("Respuesta del servicio");
    	
    	Map<String, Object> response = new HashMap<>();
    	response.put("sucess", true);
    	return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
