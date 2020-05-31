package com.example.pres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PresRepository extends JpaRepository<Pres, Long> {



    //Pres findById(int id);

   // List<Pres> findByIsbn(String isbn);

   // List<Pres> findByLecteur(int lecteur);

    //List<Pres> findByDatepret(String datepret);

    //List<Pres> findByDateretour(String dateretour);

    Pres findByDatePres(String date);
    Pres deleteById(long id);

    Pres save(Pres l);

    List<Pres> findAll();

    List<Pres> findBylecteur(long lecteur);

    @Query(value = "SELECT * FROM Pres where DATE_PRES>= ?1  and DATE_PRES<=?2 ", nativeQuery = true)
    List<Pres> chercherPresParDate(String inf,String sup);

    @Query(value = "SELECT * FROM Pres where DATE_PRES= ?1 ", nativeQuery = true)
    List<Pres> chercherPresParDatePres(String inf);

    @Query(value = "SELECT * FROM Pres where DATE_REMISE>= ?1 ", nativeQuery = true)
    List<Pres> chercherLivreEncourDemprunt(String inf);

    /*@Query(value = "SELECT Lecteur.nom, Lecteur.prenom, Livre.titre, Pres.DATE_PRES FROM   Pres, Livre, Lecteur where (Lecteur.nom=?1) and (prenom =?2) and (Pres.Livre = Livre.ISBN) and (Lecteur.id = Pres.Lecteur) ", nativeQuery = true)
    List<Object> LivreEmprunteParLecteur(String nom, String prenom);*/
}
