package com.autourducode.demo.service;

import com.autourducode.demo.models.LigneCommande;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeService {
    LigneCommande creer(LigneCommande ligneCommande);
    List<LigneCommande> lire();

    Optional<LigneCommande> lireParId(Long id);

    LigneCommande modifier(Long id,LigneCommande lignecommande);

    String supprimer(Long id);
}