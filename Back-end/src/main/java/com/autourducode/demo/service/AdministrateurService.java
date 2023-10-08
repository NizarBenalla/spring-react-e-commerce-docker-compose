package com.autourducode.demo.service;

import com.autourducode.demo.models.Administrateur;
import com.autourducode.demo.models.Facture;

import java.util.List;
import java.util.Optional;

public interface AdministrateurService {
    Administrateur creer(Administrateur produit);
    List<Administrateur> lire();

    Optional<Administrateur> lireParId(Long id);

    Administrateur modifier(Long id,Administrateur produit);

    String supprimer(Long id);

}
