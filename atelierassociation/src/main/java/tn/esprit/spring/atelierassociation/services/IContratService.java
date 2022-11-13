package tn.esprit.spring.atelierassociation.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Contrat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IContratService {


    public  Long Ajouter_contrat(Contrat contrat );

    void removeContrat(Long idContrat);


    List<Contrat> getAllContrats();

    Contrat getContratsById(int idContrat);

    void saveOrUpdate(Contrat contrats);

    void updatecontrat(Contrat contrats, int idContrat);

    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);

    @Transactional
    Map<Integer, Float> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

    @Transactional
    Integer nbContratsValides(java.sql.Date startDate, java.sql.Date endDate);

    @Transactional
    @Scheduled(fixedRate = 3000)
    String retrieveAndUpdateStatusContrat() throws Exception;
    // Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
}
