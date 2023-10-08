package com.autourducode.demo.repository;

import com.autourducode.demo.models.Client;
import com.autourducode.demo.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    //Client findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
}

