package tn.esprit.spring.atelierassociation.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Universite;
import tn.esprit.spring.atelierassociation.services.DepartementServiceimp;
import tn.esprit.spring.atelierassociation.services.UniversiteServiceimp;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/UniversiteC")
public class UniversiteController {
    @Autowired
    UniversiteServiceimp universiteServiceimp;
    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}

    @GetMapping("/alluniversite")
    @JsonIgnore
    private List<Universite> getAllUniversite()
    {
        return universiteServiceimp.retreiveAllUniversites();
    }
    @GetMapping("/alluniversites/{idUniversite}")
    private Universite getuniversitebyid(@PathVariable("idUniversite") int idUniversite)
    {
        return universiteServiceimp.retreiveuniversite(idUniversite);
    }
    @PostMapping("/addUniversite")
    @ResponseBody
    public void addUniversite(@RequestBody Universite universite){
        universiteServiceimp.Ajouter_universite(universite);
    }
    @DeleteMapping ("/removeUniversite/{idUniversite}")
    @ResponseBody
    public void removeuniversite(@PathVariable("idUniversite") Long idUniversite) {
        universiteServiceimp.removeuniversite(idUniversite);

    }
   // @PostMapping("/universites")
    private int saveuniversite(@RequestBody Universite universites)
    {
        universiteServiceimp.saveOrUpdate(universites);
        return Math.toIntExact(universites.getIdUniv());
    }
    @PutMapping("/UpdateUniversite")
    private Universite updateuniversite(@RequestBody Universite universite)
    {
        universiteServiceimp.saveOrUpdate(universite);
        return universite;
    }
    @PutMapping(value="/affecteruniversitedepartement/{idUniv}/{idDepart}")
    public void affecteruniversitedepartement(@PathVariable("idUniv") Long idUniv, @PathVariable("idDepart") Long idDepart){

        universiteServiceimp.assignUniversiteToDepartement(idUniv,idDepart);
    }
    @GetMapping("/retrieveDepartementsByUniversite/{idUniv}")
    public List<Departement> retrieveDepartementsByUniversite( @RequestParam Long idUniv) {
        return universiteServiceimp.retrieveDepartementsByUniversite(idUniv);
    }
}
