package com.autourducode.demo.service;

import com.autourducode.demo.models.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    Produit creer(Produit produit);
    List<Produit> lire();

    Produit modifier(Long id,Produit produit);

    Optional<Produit> lireParId(Long id);

    List<Produit> lireParMotcle(String motCle);

    List<Produit> lireProduitParCategorie(Long id);

    String supprimer(Long id);
}
