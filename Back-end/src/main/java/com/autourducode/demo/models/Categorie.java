package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="categorie")
@NoArgsConstructor
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categorie")
    private Long idCategorie;
    @Column(length = 150, name="description")
    private String description;

    @OneToMany
    private List<Produit>  produits;

    public List<Produit> getProduits() {
        return produits;
    }
}
