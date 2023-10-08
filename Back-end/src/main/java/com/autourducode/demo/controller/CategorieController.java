package com.autourducode.demo.controller;

import com.autourducode.demo.models.Categorie;
import com.autourducode.demo.service.CategorieService;
import com.autourducode.demo.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorie")
@CrossOrigin
@AllArgsConstructor
public class CategorieController {
    private final CategorieService categorieService ;
    @PostMapping("/create")
    public Categorie create(@RequestBody Categorie categorie){
        return categorieService.creer(categorie);
    }

    @GetMapping("/read")
    public List<Categorie> read(){
        return categorieService.lire();
    }

    @GetMapping("/read/{id}")
    public Optional<Categorie> read(@PathVariable Long id){
        return categorieService.lireParId(id);
    }

    @PutMapping("/update/{id}")
    public Categorie update(@PathVariable Long id,@RequestBody Categorie categorie){
        return categorieService.modifier(id,categorie);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return categorieService.supprimer(id);
    }
}
