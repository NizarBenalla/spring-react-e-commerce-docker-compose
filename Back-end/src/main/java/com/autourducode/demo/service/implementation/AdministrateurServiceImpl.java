package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Administrateur;
import com.autourducode.demo.repository.AdministrateurRepository;
import com.autourducode.demo.service.AdministrateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AdministrateurServiceImpl implements AdministrateurService {
    private final AdministrateurRepository administrateurRepository;


    @Override
    public Administrateur creer(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @Override
    public List<Administrateur> lire() {
        return administrateurRepository.findAll();
    }

    @Override
    public Optional<Administrateur> lireParId(Long id) {
        return administrateurRepository.findById(id);
    }

    @Override
    public Administrateur modifier(Long id, Administrateur administrateur) {
        return administrateurRepository.findById(id)
                .map(a->{
                    a.setAdresse(administrateur.getAdresse());
                    a.setNom(administrateur.getNom());
                    a.setEmail(administrateur.getEmail());
                    a.setMotDePasse(administrateur.getMotDePasse());
                    a.setSexe(administrateur.getSexe());
                    a.setType(administrateur.getType());
                    a.setPrenom(administrateur.getPrenom());
                    return administrateurRepository.save(a);
                }).orElseThrow(()->new RuntimeException("Administrateur non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        administrateurRepository.deleteById(id);
        return "Admin supprimé";
    }
}
