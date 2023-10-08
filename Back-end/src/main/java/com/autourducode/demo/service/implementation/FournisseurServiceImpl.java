package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Fournisseur;
import com.autourducode.demo.repository.FournisseurRepository;
import com.autourducode.demo.service.FournisseurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur creer(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> lire() {
        return fournisseurRepository.findAll();
    }

    @Override
    public Optional<Fournisseur> lireParId(Long id) {
        return fournisseurRepository.findById(id);
    }

    @Override
    public Fournisseur modifier(Long id, Fournisseur fournisseur) {
        return fournisseurRepository.findById(id)
                .map(c->{
                    c.setAdresse(fournisseur.getAdresse());
                    c.setNom(fournisseur.getNom());
                    c.setEmail(fournisseur.getEmail());
                    c.setMotDePasse(fournisseur.getMotDePasse());
                    c.setSexe(fournisseur.getSexe());
                    c.setPrenom(fournisseur.getPrenom());
                    return fournisseurRepository.save(fournisseur);
                }).orElseThrow(()-> new RuntimeException("Fournisseur non trouvé"));
    }

    @Override
    public String supprimer(Long id) {

        return "Fournisseur supprimé";
    }
}