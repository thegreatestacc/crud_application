package com.sovliv.crud_rest_oracle_app.service;

import com.sovliv.crud_rest_oracle_app.model.Address;
import com.sovliv.crud_rest_oracle_app.model.Client;
import com.sovliv.crud_rest_oracle_app.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity createClient(Client client) {
        logger.info("*** client was created ***");
        clientRepository.save(client);
        return ResponseEntity.ok().body(client);
    }

    public ResponseEntity getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("client didn't find"));
        logger.info("*** client was founded ***");
        return ResponseEntity.ok().body(client);
    }

    public ResponseEntity getAllClients() {
        Iterable<Client> allClients = clientRepository.findAll();
        logger.info("*** all clients were founded ***");
        return ResponseEntity.ok().body(allClients);
    }

    public ResponseEntity updateClient(Client client, Long id, String firstName, String lastName, Address address) {
        Optional<Client> optional = clientRepository.findById(id);
        if(optional.isEmpty()) {
            throw new RuntimeException("*** client didn't find ***");
        }
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        logger.info("*** client was updated ***");
        Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok().body(updatedClient);
    }

    @Transactional
    public Iterable<Client> saveAll(List<Client> clients) {
        logger.info("*** all clients saved ***");
        return clientRepository.saveAll(clients);
    }

    public ResponseEntity deleteClientById(Long id) {
        logger.info("*** current client was deleted ***");
        clientRepository.deleteById(id);
        return ResponseEntity.ok().body("client with id: " + id + ", was deleted");
    }

    public ResponseEntity deleteAllClients() {
        logger.info("*** all clients were deleted ***");
        clientRepository.deleteAll();
        return ResponseEntity.ok().body("*** all clients were deleted ***");
    }
}
