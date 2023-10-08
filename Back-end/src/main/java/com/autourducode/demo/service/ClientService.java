package com.autourducode.demo.service;

import com.autourducode.demo.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client creer(Client client);
    List<Client> lire();

    Optional<Client> lireParId(Long id);

    Client modifier(Long id,Client client);

    String supprimer(Long id);
}
