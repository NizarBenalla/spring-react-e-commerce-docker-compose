package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="produit")
@Getter
@Setter
@NoArgsConstructor

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit")
    private long id;
    @Column(length = 50,name = "nom_produit")
    private String nom;
    @Column(length = 150,name="description")
    private String description;

    @Column(length = 500,name ="image")
    private String image;
    private Integer prix;

    @OneToMany
    private List<LigneCommande> ligneCommandeList;

    public List<LigneCommande> getLigneCommandeList() {
        return ligneCommandeList;
    }

    @ManyToOne
    @JoinColumn(name = "id_fournisseur", nullable = false)
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name = "id_promotion")
    private Promotion promotion ;

    @ManyToOne
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie categorie ;
}
