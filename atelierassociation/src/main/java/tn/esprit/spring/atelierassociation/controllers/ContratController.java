package tn.esprit.spring.atelierassociation.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.services.ContratServiceimp;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ContratC")
public class ContratController {

    @Autowired
    ContratServiceimp contratServiceimp;
    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}
    @GetMapping("/allcontrat")
    @JsonIgnore
    private List<Contrat> getAllContrats()
    {
        return contratServiceimp.getAllContrats();
    }
    @GetMapping("/allcontrat/{idContrat}")
    private Contrat getBooks(@PathVariable("idContrat") int idContrat)
    {
        return contratServiceimp.getContratsById(idContrat);
    }
    @PostMapping("/addContrat")
    @ResponseBody
    @JsonIgnore
    public void addContrat(@RequestBody Contrat contrat){
        contratServiceimp.Ajouter_contrat(contrat);
    }
    @DeleteMapping ("/removeContrat/{idContrat}")
    @ResponseBody
    public void removecontrat(@PathVariable("idContrat") Long idContrat) {
        contratServiceimp.removeContrat(idContrat);

    }
   // @PostMapping("/contrats")
    private int saveContrat(@RequestBody Contrat contrats)
    {
        contratServiceimp.saveOrUpdate(contrats);
        return Math.toIntExact(contrats.getIdContrat());
    }
    @PutMapping("/UpdateContrat")
    private Contrat updatecontrat(@RequestBody Contrat contrats)
    {
        contratServiceimp.saveOrUpdate(contrats);
        return contrats;
    }

    @PostMapping("Affect/{nomE}/{prenomE}")
    @ResponseBody
    public Contrat affect(@RequestBody Contrat contrat, @PathVariable(value = "nomE") String nomE, @PathVariable(value ="prenomE") String prenomE){
     Contrat cnt=contratServiceimp.affectContratToEtudiant(contrat,nomE,prenomE);
     return cnt;
    }
    @GetMapping("ChiffreAffaire/{date1}/{date2}")
    public Map<Integer,Float> chiffreAffaire(@PathVariable(value = "date1") String date1, @PathVariable(value = "date2") String date2) throws ParseException {
        Date startDate = Date.valueOf(date1);
        Date endDate = Date.valueOf(date2);
        return contratServiceimp.getChiffreAffaireEntreDeuxDate(startDate,endDate);

    }
    @GetMapping("nbrContrat/{date1}/{date2}")
    public Integer nbContratsValides(@PathVariable(value = "date1") String date1, @PathVariable(value = "date2") String date2)
    {
        Date startDate = Date.valueOf(date1);
        Date endDate = Date.valueOf(date2);
        return contratServiceimp.nbContratsValides(startDate,endDate);
    }
    @GetMapping("status")
    public String retrieveAndUpdateStatusContrat() throws Exception {
        return contratServiceimp.retrieveAndUpdateStatusContrat();
    }

}
