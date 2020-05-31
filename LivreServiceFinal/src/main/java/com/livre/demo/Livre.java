package com.livre.demo;

import javax.persistence.Id;
import javax.persistence.Entity;
@Entity
public class Livre {
    @Id
    private Long ISBN;
    private  String auteur;
    private String titre;
    private String editeur;
    private Long edition;

    public Livre() {
    }

    public Livre(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setEdition(Long edition) {
        this.edition = edition;
    }

    public Long getISBN() {
        return ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getEditeur() {
        return editeur;
    }

    public Long getEdition() {
        return edition;
    }
}

