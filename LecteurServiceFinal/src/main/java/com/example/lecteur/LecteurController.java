package com.example.lecteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class LecteurController {
    @Autowired
    private Environment environment;

    @Autowired
    private LecteurRepository repository;

    @GetMapping("/Lecteur/{id}")
    public Lecteur retrouverLecteur
            (@PathVariable long id){

        Lecteur l =
                repository.findById(id);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/

        return l;
    }

    @GetMapping("/allLecteurs")
    public List<Lecteur> retrouverLecteur
            (){
        List<Lecteur>  l =
                repository.findAll();



        return l;
    }
    @DeleteMapping("/Lecteur/{id}")
    public Lecteur supLecteur
            (@PathVariable long id){

        Lecteur l =
                repository.deleteById(id);



        return l;
    }
    @PostMapping("/Lecteur")
    public Lecteur ajoutLecteur
            ( @RequestBody Lecteur l){

        Lecteur ll =
                repository.save(l);

        return l;
    }

    @PutMapping("/ModifierLecteur")
    public Lecteur ModifierLecteur
            ( @RequestBody Lecteur l){

        Lecteur ll =
                repository.save(l);

        return ll;
    }

    @GetMapping("/HistoriqueLivreEmprunt")
    public List<Object> HistoriqueLivreEmprunt
            ( ){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));

        List<Object> l =
                repository.HistoriqueLivreEmprunt();

        return l;
    }


}
