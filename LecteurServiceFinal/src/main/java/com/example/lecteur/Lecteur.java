package com.example.lecteur;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Date;

@Entity
public class Lecteur {
    @Id
    private Long id;
    private  String genre;
    private String nom;
    private String prenom;
    private String  adresse;
    private Date dateDeNaissance;

    public Lecteur() {
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
