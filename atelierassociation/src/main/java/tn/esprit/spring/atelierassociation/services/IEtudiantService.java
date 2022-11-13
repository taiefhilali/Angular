package tn.esprit.spring.atelierassociation.services;
import tn.esprit.spring.atelierassociation.entity.Etudiant;

import javax.transaction.Transactional;
import java.util.List;

public interface IEtudiantService {

    public  Long Ajouter_etudiant(Etudiant e );

    public void removeEtudiant(Long idEtudiant);

    List<Etudiant> retrieveAllEtudiants();

    Etudiant retrieveEtudiant(Long idEtudiant);

    void saveOrUpdate(Etudiant etudiants);

    void updatecontrat(Etudiant etudiant, int idEtudiant);

    @Transactional
    void assignEtudianttoDepartement(Long idEtudiant, Long idDepart);


    @org.springframework.transaction.annotation.Transactional
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe);

    @org.springframework.transaction.annotation.Transactional
    List<Etudiant> getEtudiantsByDepartement(Long idDepart);

    // @org.springframework.transaction.annotation.Transactional
    //List<Etudiant> getEtudiantsByDepartement(Long idDepartement);
}
