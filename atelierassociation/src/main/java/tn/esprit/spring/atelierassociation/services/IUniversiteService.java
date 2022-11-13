package tn.esprit.spring.atelierassociation.services;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Etudiant;
import tn.esprit.spring.atelierassociation.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public  Long Ajouter_universite(Universite u );

    void removeuniversite(Long idUniversite);


    List<Universite> retreiveAllUniversites();

    Universite retreiveuniversite(int idUniversite);

    void saveOrUpdate(Universite universite);

    void updatecontrat(Universite universite, int idUniversite);

    @Transactional
    void assignUniversiteToDepartement(Long idUniversite, Long idDepart);

    @Transactional
    List<Departement> retrieveDepartementsByUniversite(Long idUniversite);
}
