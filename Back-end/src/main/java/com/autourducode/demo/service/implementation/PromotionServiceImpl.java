package com.autourducode.demo.service.implementation;

import com.autourducode.demo.models.Promotion;
import com.autourducode.demo.repository.PromotionRepository;
import com.autourducode.demo.service.PromotionService;
import com.autourducode.demo.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    @Override
    public Promotion creer(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> lire() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> lireParId(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    public Promotion modifier(Long id, Promotion promotion) {
        return promotionRepository.findById(id)
                .map(c->{
                    c.setRemise(promotion.getRemise());
                    return promotionRepository.save(promotion);
                }).orElseThrow(()-> new RuntimeException("Promotion non trouvé"));
    }

    @Override
    public String supprimer(Long id) {

        return "Promotion supprimé";
    }
}
