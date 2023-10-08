package com.autourducode.demo.controller;

import com.autourducode.demo.models.LigneCommande;
import com.autourducode.demo.service.LigneCommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneCommande")
@CrossOrigin
@AllArgsConstructor
public class LigneCommandeController {
    private final LigneCommandeService ligneCommandeService;

    @PostMapping("/create")
    public LigneCommande create(@RequestBody LigneCommande client){
        return ligneCommandeService.creer(client);
    }

    @GetMapping("/read")
    public List<LigneCommande> read(){
        return ligneCommandeService.lire();
    }

    @PutMapping("/update/{id}")
    public LigneCommande update(@PathVariable Long id,@RequestBody LigneCommande client){
        return ligneCommandeService.modifier(id,client);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return ligneCommandeService.supprimer(id);
    }
}
