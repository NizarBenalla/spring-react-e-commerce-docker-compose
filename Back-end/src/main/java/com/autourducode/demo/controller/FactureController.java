package com.autourducode.demo.controller;

import com.autourducode.demo.models.Facture;
import com.autourducode.demo.service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
@CrossOrigin
@AllArgsConstructor
public class FactureController {
    private final FactureService factureService;

    @PostMapping("/create")
    public Facture create(@RequestBody Facture facture){
        return factureService.creer(facture);
    }

    @GetMapping("/read")
    public List<Facture> read(){
        return factureService.lire();
    }

    @PutMapping("/update/{id}")
    public Facture update(@PathVariable Long id, @RequestBody Facture facture){
        return factureService.modifier(id,facture);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return factureService.supprimer(id);
    }
}


