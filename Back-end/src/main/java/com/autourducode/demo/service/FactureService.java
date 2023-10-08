package com.autourducode.demo.service;

import com.autourducode.demo.models.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureService {
    Facture creer(Facture facture);
    List<Facture> lire();

    public Optional<Facture> lireParId(Long id);

    Facture modifier(Long id,Facture facture);

    String supprimer(Long id);
}
