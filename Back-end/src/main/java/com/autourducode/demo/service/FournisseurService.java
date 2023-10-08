package com.autourducode.demo.service;

import com.autourducode.demo.models.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface FournisseurService {
    Fournisseur creer(Fournisseur fournisseur);
    List<Fournisseur> lire();

    Optional<Fournisseur> lireParId(Long id);

    Fournisseur modifier(Long id,Fournisseur fournisseur);

    String supprimer(Long id);
}