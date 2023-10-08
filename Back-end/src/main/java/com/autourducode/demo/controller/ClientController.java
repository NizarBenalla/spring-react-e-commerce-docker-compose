package com.autourducode.demo.controller;

import com.autourducode.demo.models.Client;
import com.autourducode.demo.service.ClientService;
import com.autourducode.demo.service.implementation.ClientServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        return clientService.creer(client);
    }

    @GetMapping("/read")
    public List<Client> read(){
        return clientService.lire();
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable Long id,@RequestBody Client client){
        return clientService.modifier(id,client);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return clientService.supprimer(id);
    }
}
