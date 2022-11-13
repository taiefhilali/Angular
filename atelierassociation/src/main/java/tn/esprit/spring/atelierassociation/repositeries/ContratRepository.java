package tn.esprit.spring.atelierassociation.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.atelierassociation.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
   // float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    //List<Contrat> findContratByidEtudiant(Long idEtudiant);



}
