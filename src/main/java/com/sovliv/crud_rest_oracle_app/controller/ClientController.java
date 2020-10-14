package com.sovliv.crud_rest_oracle_app.controller;

import com.sovliv.crud_rest_oracle_app.model.Address;
import com.sovliv.crud_rest_oracle_app.model.Client;
import com.sovliv.crud_rest_oracle_app.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    public ResponseEntity getOneClient(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping("/add")
    public ResponseEntity createClient(Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/edit")
    public ResponseEntity editClient(@RequestBody Client client, Long id, String firstName, String lastName, Address address) {
        return clientService.updateClient(client, id, firstName, lastName, address);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        return clientService.deleteClientById(id);
    }

}
