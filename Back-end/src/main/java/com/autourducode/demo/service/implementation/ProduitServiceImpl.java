package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Produit;
import com.autourducode.demo.repository.ProduitRepository;
import com.autourducode.demo.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> lireParMotcle(String motCle) {
        return produitRepository.rechercheParNom(motCle);
    }

    @Override
    public List<Produit> lireProduitParCategorie(Long id) {
        return produitRepository.getProduitsByCategorie(id);
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p->{
                    p.setPrix(produit.getPrix());
                    p.setNom(produit.getNom());
                    p.setDescription(produit.getDescription());
                    p.setImage(produit.getImage());
                    return produitRepository.save(p);
                }).orElseThrow(()->new RuntimeException("Produit non trouvé"));
    }

    @Override
    public Optional<Produit> lireParId(Long id) {
        return produitRepository.findById(id);
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé";
    }
}
