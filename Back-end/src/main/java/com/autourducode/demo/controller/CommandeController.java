package com.autourducode.demo.controller;

import com.autourducode.demo.models.Commande;
import com.autourducode.demo.service.CommandeService;
import com.autourducode.demo.service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin
@AllArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping("/create")
    public Commande create(@RequestBody Commande commande){
        return commandeService.creer(commande);
    }

    @GetMapping("/read")
    public List<Commande> read(){
        return commandeService.lire();
    }

    @PutMapping("/update/{id}")
    public Commande update(@PathVariable Long id,@RequestBody Commande commande){
        return commandeService.modifier(id,commande);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return commandeService.supprimer(id);
    }
}
