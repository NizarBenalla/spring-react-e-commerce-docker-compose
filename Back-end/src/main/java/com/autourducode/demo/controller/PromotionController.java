package com.autourducode.demo.controller;

import com.autourducode.demo.models.Promotion;
import com.autourducode.demo.service.PromotionService;
import com.autourducode.demo.service.implementation.PromotionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotion")
@CrossOrigin
@AllArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;

    @PostMapping("/create")
    public Promotion create(@RequestBody Promotion promotion){
        return promotionService.creer(promotion);
    }

    @GetMapping("/read")
    public List<Promotion> read(){
        return promotionService.lire();
    }

    @PutMapping("/update/{id}")
    public Promotion update(@PathVariable Long id,@RequestBody Promotion promotion){
        return promotionService.modifier(id,promotion);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return promotionService.supprimer(id);
    }
}
