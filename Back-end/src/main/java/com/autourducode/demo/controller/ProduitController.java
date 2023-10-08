package com.autourducode.demo.controller;

import com.autourducode.demo.models.Produit;
import com.autourducode.demo.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produit")
@CrossOrigin
@AllArgsConstructor
@Controller
public class ProduitController {
    private ProduitService produitService ;

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit){
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read(){
        return produitService.lire();
    }

    @GetMapping("/search/{id}")
    public Optional<Produit> readById(@PathVariable Long id) {
        return produitService.lireParId(id);
    }

    @GetMapping("/read/{id}")
    public List<Produit> readByCategorie(@PathVariable Long id){
        return produitService.lireProduitParCategorie(id); }

    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id,@RequestBody Produit produit){
        return produitService.modifier(id,produit);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
         return produitService.supprimer(id);
    }
}
