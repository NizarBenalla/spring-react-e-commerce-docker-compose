package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="promotion")
@NoArgsConstructor
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromotion;
    private float remise;

   @OneToMany
    private List<Produit> produitList;

    public List<Produit> getProduitList() {
        return produitList;
    }
}
