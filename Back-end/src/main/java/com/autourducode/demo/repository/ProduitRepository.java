package com.autourducode.demo.repository;

import com.autourducode.demo.models.Categorie;
import com.autourducode.demo.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @Query(value = "SELECT * FROM  produit  where nom_produit like \"%param%\"" +
            "or description like \"%param%\"",nativeQuery = true)
    List<Produit> rechercheParNom(@Param("param") String nom);

    @Query(value = "SELECT * FROM  produit  where id_categorie =:id_cat ",nativeQuery = true)
    List<Produit> getProduitsByCategorie(@Param("id_cat") Long id);
}
