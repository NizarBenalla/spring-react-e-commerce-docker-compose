package com.autourducode.demo.service;

import com.autourducode.demo.models.Categorie;
import com.autourducode.demo.models.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    Categorie creer(Categorie produit);
    List<Categorie> lire();

    Optional<Categorie> lireParId(Long id);

    Categorie modifier(Long id,Categorie produit);

    String supprimer(Long id);


}
