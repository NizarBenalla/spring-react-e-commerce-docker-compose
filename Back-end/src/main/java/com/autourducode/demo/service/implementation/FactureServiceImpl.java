package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Facture;
import com.autourducode.demo.models.Facture;
import com.autourducode.demo.repository.FactureRepository;
import com.autourducode.demo.service.AdministrateurService;
import com.autourducode.demo.service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureRepository facturerepository;
    @Override
    public Facture creer(Facture facture) {
        return facturerepository.save(facture);
    }

    @Override
    public List<Facture> lire() {
        return facturerepository.findAll();
    }

    @Override
    public Optional<Facture> lireParId(Long id) {
        return facturerepository.findById(id);
    }

    @Override
    public Facture modifier(Long id, Facture facture) {
        return facturerepository.findById(id)
                .map(f->{
                    f.setDate(facture.getDate());
                    f.setMontantTotal(facture.getMontantTotal());
                    return facturerepository.save(facture);
                }).orElseThrow(()-> new RuntimeException("Facture non trouvé"));
    }

    @Override
    public String supprimer(Long id) {

        return "Facture supprimé";
    }
}
