package com.autourducode.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="client")
@NoArgsConstructor
@Getter
@Setter
public class Client extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_client")
    public Long getIdPersonne() {
        return super.getIdPersonne();
    }

    @Column(name="nom" , length = 50)
    @Override
    public String getNom() {
        return super.getNom();
    }
    @Column(name="prenom",length = 50)
    @Override
    public String getPrenom() {
        return super.getPrenom();
    }
    @Column(name="email",length = 150)
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Column(name="adresse", length=250)
    @Override
    public String getAdresse() {
        return super.getAdresse();
    }

    @Column(name="mot_de_passe", length = 250)
    @Override
    public String getMotDePasse() {
        return super.getMotDePasse();
    }

    @Column(name="sexe", length = 250)
    @Override
    public String getSexe() {
        return super.getSexe();
    }

    private String identite;
    private String numeroCarteBancaire;


    private List<Commande> commandeList;
    @OneToMany
    public List<Commande> getCommandeList() {
        return commandeList;
    }


    private List<Facture> factureList;
    @OneToMany
    public List<Facture> getFactureList() {
        return factureList;
    }
}
