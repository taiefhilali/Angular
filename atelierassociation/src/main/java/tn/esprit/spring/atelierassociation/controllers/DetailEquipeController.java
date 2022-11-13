package tn.esprit.spring.atelierassociation.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.DetailEquipe;
import tn.esprit.spring.atelierassociation.services.DepartementServiceimp;
import tn.esprit.spring.atelierassociation.services.DetailEquipeimp;

import java.util.List;

@RestController
@RequestMapping("/DetailEquipeC")
public class DetailEquipeController {

    @Autowired
    DetailEquipeimp detailEquipeimp;
    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}
    @GetMapping("/alldetailsequipe")
    @JsonIgnore
    private List<DetailEquipe> getAllDetailsequipe()
    {
        return detailEquipeimp.getAlldetailsequipes();
    }
    @GetMapping("/alldetailsequipes/{idDeatilEquipe}")
    private DetailEquipe getdetailsequipes(@PathVariable("idDeatilEquipe") int idDeatilEquipe)
    {
        return detailEquipeimp.getdetailsequipesById(idDeatilEquipe);
    }
    @PostMapping("/addDetailequipe")
    @ResponseBody
    @JsonIgnore
    public void addDetailequipe(@RequestBody DetailEquipe detailEquipes){
        detailEquipeimp.Ajouter_detailequipe(detailEquipes);
    }
    @DeleteMapping ("/removeDetailequipe/{idDeatilEquipe}")
    @ResponseBody
    public void removedetailequipe(@PathVariable("idDeatilEquipe") Long idDeatilEquipe) {
        detailEquipeimp.removeDetailequipe(idDeatilEquipe);

    }
   // @PostMapping("/detailequipes")
    private int saveDetailequipe(@RequestBody DetailEquipe detailEquipe)
    {
        detailEquipeimp.saveOrUpdate(detailEquipe);
        return Math.toIntExact(detailEquipe.getIdDeatilEquipe());
    }
    @PutMapping("/UpdateDetailEquipe")
    private DetailEquipe updatedetailequipe(@RequestBody DetailEquipe detailEquipes)
    {
        detailEquipeimp.saveOrUpdate(detailEquipes);
        return detailEquipes;
    }
}
