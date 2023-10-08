package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.LigneCommande;
import com.autourducode.demo.repository.LigneCommandeRepository;
import com.autourducode.demo.service.LigneCommandeService;
import com.autourducode.demo.service.LigneCommandeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;
    @Override
    public LigneCommande creer(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public List<LigneCommande> lire() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public Optional<LigneCommande> lireParId(Long id) {
        return ligneCommandeRepository.findById(id);
    }

    @Override
    public LigneCommande modifier(Long id, LigneCommande ligneCommande) {
        return ligneCommandeRepository.findById(id)
                .map(c->{
                    c.setQuantite(ligneCommande.getQuantite());

                    return ligneCommandeRepository.save(ligneCommande);
                }).orElseThrow(()-> new RuntimeException("LigneCommande non trouvé"));
    }

    @Override
    public String supprimer(Long id) {

        return "LigneCommande supprimé";
    }
}