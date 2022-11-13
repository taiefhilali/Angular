package tn.esprit.spring.atelierassociation.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Equipe;
import tn.esprit.spring.atelierassociation.services.ContratServiceimp;
import tn.esprit.spring.atelierassociation.services.EquipeServiceimp;

import java.util.List;

@RestController
@RequestMapping("/EquipeC")
public class EquipeController {


    @Autowired
    EquipeServiceimp equipeServiceimp;
    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}
    @GetMapping("/allequipes")
    @JsonIgnore
    private List<Equipe> getAllEquipes()
    {
        return equipeServiceimp.getAllEquipes();
    }
    @GetMapping("/allequipes/{idEquipe}")
    private Equipe getEquipesById(@PathVariable("idEquipe") int idEquipe)
    {
        return equipeServiceimp.getEquipesById(idEquipe);
    }
    @PostMapping("/addEquipe")
    @ResponseBody

    public void addEquipe(@RequestBody Equipe equipe){
        equipeServiceimp.Ajouter_equipe(equipe);
    }
    @DeleteMapping ("/removeEquipe/{idEquipe}")
    @ResponseBody
    public void removeequipe(@PathVariable("idEquipe") Long idEquipe) {
        equipeServiceimp.removeEquipe(idEquipe);

    }
   // @PostMapping("/equipes")
    private int saveEquipe(@RequestBody Equipe equipe)
    {
        equipeServiceimp.saveOrUpdate(equipe);
        return Math.toIntExact(equipe.getIdEquipe());
    }
    @PutMapping("/UpdateEquipe")
    private Equipe updateequipe(@RequestBody Equipe equipes)
    {
        equipeServiceimp.saveOrUpdate(equipes);
        return equipes;
    }
}
