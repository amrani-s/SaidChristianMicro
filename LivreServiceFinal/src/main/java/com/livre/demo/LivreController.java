package com.livre.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
public class LivreController {
    @Autowired
    private Environment environment;

    @Autowired
    private LivreRepository repository;

    @GetMapping("/Livre/{id}")
    public Livre retrouverLivre
            (@PathVariable long id){

        Livre l =
                repository.findById(id);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/

        return l;
    }


    @GetMapping("/LivreParTitre/{s}")
    public Livre retrouverLivreParTitre
            (@PathVariable String s){

        Livre l =
                repository.findBytitre(s);

        return l;
    }

    @GetMapping("/LivreParAuteur/{s}")
    public Livre retrouverLivreParAuteur
            (@PathVariable String s){

        Livre l =
                repository.findByauteur(s);

        return l;
    }

    @GetMapping("/allLivres")
    public List< Livre > retrouverLivres
            (){

        List< Livre > l =
                repository.findAll();

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/

        return l;
    }

    @DeleteMapping("/SupLivre/{id}")
    public Livre supLivre
            (@PathVariable long id){

        Livre l =
                repository.deleteById(id);

    /*tauxChange.setPort(
        Integer.parseInt(environment.getProperty("local.server.port")));*/

        return l;
    }


    @PutMapping("/ModifierLivre")
    public Livre ModifierLivre
            ( @RequestBody Livre l){

        Livre ll =
                repository.save(l);

        return l;
    }


    @PostMapping("/AjoutLivre")
    public Livre ajoutLivre
            ( @RequestBody Livre l){

        Livre ll =
                repository.save(l);

        return l;
    }

    @GetMapping("/Test/{inf}/{sup}")
    public List<Livre> testsql
            ( @PathVariable long inf,@PathVariable long sup){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));

        List<Livre> l =
                repository.chercherLivre(inf,sup);

        return l;
    }
}