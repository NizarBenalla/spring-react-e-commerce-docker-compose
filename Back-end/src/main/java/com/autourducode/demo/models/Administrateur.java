package com.autourducode.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Admin")
@NoArgsConstructor
@Getter
@Setter
public class Administrateur extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_admin")
    @Override
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

    @Column(length = 25,name="role")
    private String type;
}
