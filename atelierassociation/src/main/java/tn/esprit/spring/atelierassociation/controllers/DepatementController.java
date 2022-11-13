package tn.esprit.spring.atelierassociation.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Etudiant;
import tn.esprit.spring.atelierassociation.repositeries.DepartementRepository;
import tn.esprit.spring.atelierassociation.services.DepartementServiceimp;
import tn.esprit.spring.atelierassociation.services.EtudiantServiceimp;

import java.util.List;

@RestController
@RequestMapping("/DepartementC")
public class DepatementController {

    @Autowired
    DepartementServiceimp departmentServiceimp;
    //http://localhost:8088/Etudiant/add-Etudiant
    //{prenomE:"ali",nomE:"ali"}
    @GetMapping("/alldepartement")
    @JsonIgnore
    private List<Departement> getAllDepartment()
    {
        return departmentServiceimp.getAllDepartments();
    }
    @GetMapping("/alldepartement/{idDepart}")
    private Departement getDepatement(@PathVariable("idDepart") int idDepart)
    {
        return departmentServiceimp.getDepartmentsById( idDepart);
    }
    @PostMapping("/addDepartement")
    @ResponseBody
    @JsonIgnore
    public void addDepartement(@RequestBody Departement departement){
        departmentServiceimp.Ajouter_department(departement);
    }
    @DeleteMapping ("/removeDepartement/{idDepart}")
    @ResponseBody
    public void removedepartement(@PathVariable("idDepart") Long idDepart) {
        departmentServiceimp.removeDepartment(idDepart);

    }
    //@PostMapping("/departements")
    private int saveDepartement(@RequestBody Departement departement)
    {
        departmentServiceimp.saveOrUpdate(departement);
        return Math.toIntExact(departement.getIdDepart());
    }
    @PutMapping("/UpdateDepartement")
    private Departement updatedepartement(@RequestBody Departement departement)
    {
        departmentServiceimp.saveOrUpdate(departement);
        return departement;
    }

}
