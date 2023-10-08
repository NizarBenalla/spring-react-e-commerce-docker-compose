package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="fournisseur")
@Getter
@Setter
@NoArgsConstructor
public class Fournisseur extends Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fournisseur")
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
    private String nomEntreprise;



    private Set<Produit> produits;
    @OneToMany
    public Set<Produit> getProduits() {
        return produits;
    }

}
