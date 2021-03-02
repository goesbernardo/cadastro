package com.bernardo.cadastro.controller;

import com.bernardo.cadastro.dto.ClientDto;
import com.bernardo.cadastro.model.Client;
import com.bernardo.cadastro.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody  ClientDto clientDto){
        try {
            Client client = clientService.insertClient(Client.create(clientDto));
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateClient(@RequestBody ClientDto clientDto, @PathVariable("id") Long id) {
        Client client = Client.create(clientDto);
        client.setId(id);
        Client updateClient = clientService.updateClient(client);

        return Objects.nonNull(updateClient)? ResponseEntity.ok(updateClient) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity deleteClient(Long id) {
        return clientService.deleteClient(id)?
                ResponseEntity.ok().build() : ResponseEntity.notFound().build();

    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable ("id") Long id) {
        Optional<Client> client = clientService.findById(id);

        return client.isPresent() ? ResponseEntity.ok(client.get()) : ResponseEntity.notFound().build();

    }

}
