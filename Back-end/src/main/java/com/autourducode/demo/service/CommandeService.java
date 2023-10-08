package com.autourducode.demo.service;

import com.autourducode.demo.models.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {
    Commande creer(Commande commande);
    List<Commande> lire();

    Optional<Commande> lireParId(Long id);

    Commande modifier(Long id,Commande commande);

    String supprimer(Long id);
}
