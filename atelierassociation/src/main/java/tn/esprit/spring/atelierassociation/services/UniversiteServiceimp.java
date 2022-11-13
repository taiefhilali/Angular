package tn.esprit.spring.atelierassociation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Universite;
import tn.esprit.spring.atelierassociation.repositeries.DepartementRepository;
import tn.esprit.spring.atelierassociation.repositeries.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UniversiteServiceimp implements IUniversiteService {


    @Autowired
    UniversiteRepository universiteRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Override
    public Long Ajouter_universite(Universite u) {
        universiteRepository.save(u);
        log.info("Ajouter universite");
        return u.getIdUniv();
    }


    @Override
    public void removeuniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }



    @Override
    public List<Universite> retreiveAllUniversites() {
        List<Universite> universites = new ArrayList<Universite>();
        universiteRepository.findAll().forEach(contrats1 -> universites.add(contrats1));
        return universites;
    }
    @Override
    public Universite retreiveuniversite(int idUniversite) {
        return universiteRepository.findById((long) idUniversite).get();

    }
    @Override
    public void saveOrUpdate(Universite universite) {
       universiteRepository .save(universite);
    }
    @Override
    public void updatecontrat(Universite universite, int idUniversite)
    {
        universiteRepository.save(universite);
    }
    @Override
    @Transactional
    public void assignUniversiteToDepartement(Long idUniv, Long idDepart) {
        Universite u=universiteRepository.findById(idUniv).get();
        Departement d=  departementRepository.findById(idDepart).get();
        u.getDpts().add(d);
        universiteRepository.save(u);
    }

    @Override
    @Transactional
    public List<Departement> retrieveDepartementsByUniversite(Long idUniv) {
        Universite universite = this.retreiveuniversite(Math.toIntExact(idUniv));
        if(universite != null)
        {
            return new ArrayList<>(universite.getDpts());
        }
        return null;
    }


}
