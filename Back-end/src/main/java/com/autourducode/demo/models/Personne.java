package com.autourducode.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter

public class Personne {

    protected Long idPersonne;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;
    protected String sexe;
    protected String adresse;

}
