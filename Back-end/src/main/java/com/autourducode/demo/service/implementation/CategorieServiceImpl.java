package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Categorie;
import com.autourducode.demo.models.Produit;
import com.autourducode.demo.repository.CategorieRepository;
import com.autourducode.demo.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepository categorieRepository;
    @Override
    public Categorie creer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> lire() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<Categorie> lireParId(Long id) {
        return categorieRepository.findById(id);
    }

    @Override
    public Categorie modifier(Long id, Categorie categorie) {
        return categorieRepository.findById(id)
                .map(p->{
                    p.setDescription(categorie.getDescription());
                    //p.setProduits(categorie.getProduits());
                    return categorieRepository.save(categorie);
                }).orElseThrow(()->new RuntimeException("Categorie non trouvé"));
    }

    @Override
    public String supprimer(Long id) {
        categorieRepository.deleteById(id);
        return "categorie supprimé";
    }




}
