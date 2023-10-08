package com.autourducode.demo.repository;

import com.autourducode.demo.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
