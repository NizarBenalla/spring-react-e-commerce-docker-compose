package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ligne_commande")
@NoArgsConstructor
@Getter
@Setter
public class LigneCommande {
    @Id
    private Long idLigneCommande ;

    @ManyToOne
    @JoinColumn(name="id_produit", nullable=false)
    private Produit produit;

    @ManyToOne
    @JoinColumn(name="id_commande", nullable=false)
    private Commande commande;
    private int quantite;

}
