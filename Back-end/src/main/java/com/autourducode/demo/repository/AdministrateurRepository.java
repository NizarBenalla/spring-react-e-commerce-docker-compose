package com.autourducode.demo.repository;

import com.autourducode.demo.models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
