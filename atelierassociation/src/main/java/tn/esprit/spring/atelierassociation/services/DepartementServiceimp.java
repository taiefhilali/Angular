package tn.esprit.spring.atelierassociation.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.repositeries.DepartementRepository;
import tn.esprit.spring.atelierassociation.repositeries.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class DepartementServiceimp  implements IDepartementService{
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public Long Ajouter_department(Departement departement) {
        departementRepository.save(departement);
        log.info("Ajouter departement");
        return departement.getIdDepart();
    }
    @Override
    public void removeDepartment(Long idDepart) {
        departementRepository.deleteById(idDepart);

    }
    @Override
    public List<Departement> getAllDepartments() {
        List<Departement> departements = new ArrayList<Departement>();
        departementRepository.findAll().forEach(contrats1 -> departements.add(contrats1));
        return departements;
    }
     @Override
    public Departement getDepartmentsById(Integer idDepart) {
        return departementRepository.findById((long) idDepart).get();

    }
    @Override
    public void saveOrUpdate(Departement departement) {
        departementRepository.save(departement);
    }
    @Override
    public void updatedepartement(Departement departement, int idDepart)
    {
        departementRepository.save(departement);}




}


