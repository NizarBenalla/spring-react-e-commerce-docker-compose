package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Client;
import com.autourducode.demo.repository.ClientRepository;
import com.autourducode.demo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Client creer(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> lire() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> lireParId(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client modifier(Long id, Client client) {
        return clientRepository.findById(id)
                .map(c->{
                    c.setAdresse(client.getAdresse());
                    c.setNom(client.getNom());
                    c.setEmail(client.getEmail());
                    c.setMotDePasse(client.getMotDePasse());
                    c.setSexe(client.getSexe());
                    c.setPrenom(client.getPrenom());
                    c.setIdentite(client.getIdentite());
                    c.setNumeroCarteBancaire(client.getNumeroCarteBancaire());
                    return clientRepository.save(client);
                }).orElseThrow(()-> new RuntimeException("Client non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        clientRepository.deleteById(id);
        return "Client supprimé";
    }
}
