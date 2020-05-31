package com.livre.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findById(long id);

    Livre deleteById(long id);

    Livre findBytitre(String s);
    Livre findByauteur(String s);

    Livre save(Livre l);

    List<Livre> findAll();

    @Query(value = "SELECT * FROM LIVRE where edition>= ?1  and edition<=?2 ", nativeQuery = true)
    List<Livre> chercherLivre(long inf,long sup);

}