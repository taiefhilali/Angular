package tn.esprit.spring.atelierassociation.services;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Etudiant;

import java.util.List;

public interface IDepartementService {


    Long Ajouter_department(Departement departement);

    void removeDepartment(Long idDepart);

    List<Departement> getAllDepartments();

 //   Departement getDepartmentsById(int idDepart);

  //  Departement getDepartmentsById(Long idDepart);

    Departement getDepartmentsById(Integer idDepart);

    void saveOrUpdate(Departement departement);

    void updatedepartement(Departement departement, int idDepart);



}
