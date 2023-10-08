package com.autourducode.demo.controller;

import com.autourducode.demo.models.Administrateur;
import com.autourducode.demo.service.AdministrateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrateur")
@CrossOrigin
@AllArgsConstructor
public class AdministrateurController {
    private final AdministrateurService administrateurService ;
    @PostMapping("/create")
    public Administrateur create(@RequestBody Administrateur adminstrateur){
        return administrateurService.creer(adminstrateur);
    }

    @GetMapping("/read")
    public List<Administrateur> read(){
        return administrateurService.lire();
    }

    @GetMapping("/read/{id}")
    public Optional<Administrateur> read(@PathVariable Long id){
        return administrateurService.lireParId(id);
    }

    @PutMapping("/update/{id}")
    public Administrateur update(@PathVariable Long id,@RequestBody Administrateur adminstrateur){
        return administrateurService.modifier(id,adminstrateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return administrateurService.supprimer(id);
    }
}
