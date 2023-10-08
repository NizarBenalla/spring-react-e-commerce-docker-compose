package com.autourducode.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity
@Table(name="facture")
@NoArgsConstructor
@Getter
@Setter
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_facture")
    private Long idFacture;

    private Date date;

    private double montantTotal;
    @ManyToOne
    @JoinColumn(name="id_client", nullable=false)
    private Client client;

    @OneToMany
    private List<Commande> commandeList;

    public List<Commande> getCommandeList() {
        return commandeList;
    }
}
