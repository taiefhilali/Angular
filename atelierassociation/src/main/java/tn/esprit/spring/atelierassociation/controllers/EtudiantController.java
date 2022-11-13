package tn.esprit.spring.atelierassociation.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Etudiant;

import org.springframework.stereotype.Controller;
import tn.esprit.spring.atelierassociation.repositeries.EquipeRepository;
import tn.esprit.spring.atelierassociation.repositeries.EtudiantRepository;
import tn.esprit.spring.atelierassociation.services.EtudiantServiceimp;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/EtudiantC")
public class EtudiantController {
    @Autowired
    EtudiantServiceimp etudiantServiceimp;

    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}
    @GetMapping("/retrieveAllEtudiants")
    private List<Etudiant> retrieveAllEtudiants() {
        return etudiantServiceimp.retrieveAllEtudiants();
    }

    @GetMapping("/retrieveetudiant/{idEtudiant}")
    @ResponseBody
    private Etudiant retreiveEtudiant(@PathVariable("idEudiant") int idEtudiant) {
        return etudiantServiceimp.retrieveEtudiant((long) idEtudiant);
    }

    @PostMapping("/addEtudiant")
    @ResponseBody
    public void addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantServiceimp.Ajouter_etudiant(etudiant);
    }

    @DeleteMapping("/removeEtudiant/{idEtudiant}")
    @ResponseBody
    public void removeEtudiant(@PathVariable("idEtudiant") Long idEtudiant) {
        etudiantServiceimp.removeEtudiant(idEtudiant);


    }


    // @PostMapping("/etudiants")
    private int saveEtudiant(@RequestBody Etudiant etudiant) {
        etudiantServiceimp.saveOrUpdate(etudiant);
        return Math.toIntExact(etudiant.getIdEtudiant());
    }

    @PutMapping("/UpdateEtudiant")
    private Etudiant updateetudiant(@RequestBody Etudiant etudiant) {
        etudiantServiceimp.saveOrUpdate(etudiant);
        return etudiant;
    }

    @PutMapping(value = "/affecter_etudiant_departement/{idEtudiant}/{idDepart}")
    public void affecteretudiantdepartement(@PathVariable("idEtudiant") Long idEtudiant, @PathVariable("idDepart") Long idDepart) {

        etudiantServiceimp.assignEtudianttoDepartement(idEtudiant, idDepart);
    }

    @PostMapping (value = "/affecter_etudiant_contrat_equipe/{idEquipe}/{idContrat}")
    @ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable("idContrat") Long idContrat, @PathVariable("idEquipe") Long idEquipe) {
        Etudiant etud = etudiantServiceimp.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
        return etud;
    }


    @GetMapping (value = "/affecter_list_etudiant_depart/{idDepart}")

    public List<Etudiant> getEtudiantsByDepartement (@PathVariable("idDepart") Long idDepart) {
      return etudiantServiceimp.getEtudiantsByDepartement(idDepart);

    }
}

