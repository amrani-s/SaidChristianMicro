package com.example.lecteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LecteurRepository extends JpaRepository<Lecteur, Long> {
    Lecteur findById(long id);
    Lecteur deleteById(long id);
    Lecteur save(Lecteur l);
    List<Lecteur> findAll();

    @Query(value = "SELECT P.Livre, P.Lecteur, l.nom, li.titre  FROM LECTEUR l, Pres P, Livre li where  l.id = P.Lecteur ", nativeQuery = true)
    List<Object> HistoriqueLivreEmprunt();


}
