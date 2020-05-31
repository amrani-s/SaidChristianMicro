package com.example.pres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class PresController {
    @Autowired
    private Environment environment;

    @Autowired
    private PresRepository repository;
    /* @Autowired
   private PresRepositoryId  repositoryId;
    @GetMapping("/PresLivre/{id}")
    public Pres retrouverPres
            (@PathVariable long id){

        Pres l = repositoryId.findById(id);


        return l;
    }*/


    @GetMapping("/Pres/{date}")
    public Pres retrouverLecteur
            (@PathVariable String date){
        Pres l =  new  Pres();

        try {
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String d = simpleDateFormat.format(new Date());
            System.out.println(date);
            System.out.println("la date est "+d);
            l =
                    repository.findByDatePres(d);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return l;
    }


    @GetMapping("/HistoriqueDePres")
    public List<Pres> retrouverHistoriquePres
            (){
        List<Pres> l =
                repository.findAll();



        return l;
    }

    @DeleteMapping("/supPres/{id}")
    public Pres supPres
    (@PathVariable long id){

        Pres l =
                repository.deleteById(id);



        return l;
    }
    @PostMapping("/ajoutPres")
    public Pres ajoutPres
    ( @RequestBody Pres l){

        Pres ap =
                repository.save(l);



        return ap;
    }

    @GetMapping("/between/{inf}/{sup}")
    public List<Pres> testsql
            ( @PathVariable String inf,@PathVariable String sup){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));

        List<Pres> l =
                repository.chercherPresParDate(inf,sup);

        return l;
    }

    @GetMapping("/TestByDate/{inf}")
    public List<Pres> chercherPresParDate
            ( @PathVariable String inf){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));

        List<Pres> l =
                repository.chercherPresParDatePres(inf);


        return l;
    }

    @GetMapping("/LivreEnCourEmprunt")
    public List<Pres> LivreEnCourEmprunt
            ( ){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        System.out.println(format.format(calendar.getTime()));

        List<Pres> l =
                repository.chercherLivreEncourDemprunt(format.format(calendar.getTime()));

        return l;
    }

    @GetMapping("/LivreEmprunteParLecteur/{lecteur}")
    public List<Pres> HistoriqueLivreEmprunterParLecteur
            ( @PathVariable long lecteur){



        List<Pres> l =
                repository.findBylecteur(lecteur);

        return l;
    }

}