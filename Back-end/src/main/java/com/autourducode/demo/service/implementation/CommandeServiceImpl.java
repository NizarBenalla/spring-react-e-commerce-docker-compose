package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Commande;
import com.autourducode.demo.models.Commande;
import com.autourducode.demo.repository.CommandeRepository;
import com.autourducode.demo.service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;
    @Override
    public Commande creer(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> lire() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> lireParId(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public Commande modifier(Long id, Commande commande) {
        return commandeRepository.findById(id)
                .map(c->{
                    c.setEtat(commande.getEtat());
                    c.setModeLivraison(commande.getModeLivraison());
                    c.setPrixTotal(commande.getPrixTotal());
                    return commandeRepository.save(commande);
                }).orElseThrow(()->new RuntimeException("Commande non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        commandeRepository.deleteById(id);
        return "commande supprimé";
    }

}
