package com.autourducode.demo.service;

import com.autourducode.demo.models.Promotion;

import java.util.List;
import java.util.Optional;

public interface PromotionService {
    Promotion creer(Promotion promotion);
    List<Promotion> lire();

    Optional<Promotion> lireParId(Long id);

    Promotion modifier(Long id,Promotion promotion);

    String supprimer(Long id);
}