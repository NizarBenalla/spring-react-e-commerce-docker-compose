package com.autourducode.demo.repository;

import com.autourducode.demo.models.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,Long> {
}
