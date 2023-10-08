package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="commande")
@NoArgsConstructor
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_commande")
    private Long idCommande;
    private String etat;
    private double prixTotal;
    private String modeLivraison;
    @ManyToOne
    @JoinColumn(name="id_client", nullable=false)
    private Client client;
    @ManyToOne
    @JoinColumn(name="id_facture")
    private Facture facture;
    @OneToMany
    private List<LigneCommande> ligneCommande;

    public List<LigneCommande> getLigneCommande() {
        return ligneCommande;
    }
}
