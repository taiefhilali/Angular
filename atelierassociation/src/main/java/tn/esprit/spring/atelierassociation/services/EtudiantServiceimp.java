package tn.esprit.spring.atelierassociation.services;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Equipe;
import tn.esprit.spring.atelierassociation.entity.Etudiant;
import tn.esprit.spring.atelierassociation.repositeries.ContratRepository;
import tn.esprit.spring.atelierassociation.repositeries.DepartementRepository;
import tn.esprit.spring.atelierassociation.repositeries.EquipeRepository;
import tn.esprit.spring.atelierassociation.repositeries.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;


@ComponentScan
@Service
@Slf4j
public class EtudiantServiceimp implements IEtudiantService{

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratRepository;

   EtudiantRepository etudiantRepository;
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Long Ajouter_etudiant(Etudiant e) {
        etudiantRepository.save(e);
        log.info("Ajouter Etudiant");
        return e.getIdEtudiant();
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiantRepository.findAll().forEach(etudiants1 -> etudiants.add(etudiants1));
        return etudiants;
    }
    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant){
        return etudiantRepository.findById((long) idEtudiant).get();

    }
    @Override
    public void saveOrUpdate(Etudiant etudiants) {
        etudiantRepository.save(etudiants);
    }
    @Override

    public void updatecontrat(Etudiant etudiant, int idEtudiant)
    {
        etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public void assignEtudianttoDepartement(Long idEtudiant, Long idDepart){

  Etudiant e=etudiantRepository.findById(idEtudiant).get();
  Departement d= departementRepository.findById(idDepart).get();
      e.setDept(d);



    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Equipe eq= equipeRepository.findById(idEquipe).get();
        Contrat c= contratRepository.findById(idContrat).get();
      // Etudiant e1= etudiantRepository.findById(e.getIdEtudiant()).get();

        c.setEtudiant(e);
        eq.getEtudiants().add(e);
        return e;
    }

    @Scheduled(fixedRate = 20000)
    public void fixedRateMethod(){
        System.out.println("Method with fixed Rate");
    }



    @Override
    @Transactional
    public  List<Etudiant> getEtudiantsByDepartement(Long idDepart){
        Departement d= departementRepository.findById(idDepart).get();
        return  d.getEtuds();
    }
}


