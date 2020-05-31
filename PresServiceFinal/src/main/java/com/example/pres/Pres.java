package com.example.pres;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
public class Pres {
    @Id
    private Long id;
    @Column(name = "ISBN")
    private String ISBN;
    @Column(name = "lecteur")
    private long lecteur;
    @Column(name = "datePres")
    private Date datePres;
    @Column(name = "dateRemise")
    private Date dateRemise;

    public Pres() {
    }

    public Pres(Long id, String ISBN, long lecteur, Date datePres, Date dateRemise) {
        this.id = id;
        this.ISBN = ISBN;
        this.lecteur = lecteur;
        this.datePres = datePres;
        this.dateRemise = dateRemise;
    }

    public Long getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public long getLecteur() {
        return lecteur;
    }

    public Date getDatePres() {
        return datePres;
    }

    public Date getDateRemise() {
        return dateRemise;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setLecteur(long lecteur) {
        this.lecteur = lecteur;
    }

    public void setDatePres(Date datePres) {
        this.datePres = datePres;
    }

    public void setDateRemise(Date dateRemise) {
        this.dateRemise = dateRemise;
    }
}
