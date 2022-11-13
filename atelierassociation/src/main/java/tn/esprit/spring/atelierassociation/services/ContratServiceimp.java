package tn.esprit.spring.atelierassociation.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Etudiant;
import tn.esprit.spring.atelierassociation.repositeries.ContratRepository;
import tn.esprit.spring.atelierassociation.repositeries.EtudiantRepository;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class ContratServiceimp implements IContratService {
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Long Ajouter_contrat(Contrat contrat) {
        contratRepository.save(contrat);
        log.info("Ajouter contrat");
        return contrat.getIdContrat();
    }
    @Override
    public void removeContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);

    }
    @Override
    public List<Contrat> getAllContrats() {
        List<Contrat> contrats = new ArrayList<Contrat>();
        contratRepository.findAll().forEach(contrats1 -> contrats.add(contrats1));
        return contrats;
    }
    @Override
    public Contrat getContratsById(int idContrat) {
        return contratRepository.findById((long) idContrat).get();

    }
    @Override
    public void saveOrUpdate(Contrat contrats) {
        contratRepository.save(contrats);
    }
    @Override
    public void updatecontrat(Contrat contrats, int idContrat)
    {
        contratRepository.save(contrats);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        if (etudiant != null) {
            System.out.println("etudiant existe");
            int nombreContratActif = 0;
            for (Contrat contrat : etudiant.getCntrats()) {
                if (contrat.getArchive() != true)
                    nombreContratActif++;
            }
            if (nombreContratActif < 5) {
                ce.setEtudiant(etudiant);
                //  ce.setArchive(true);


                //updatecontrat();
            }
        }else
            System.out.println("etudiant non existant");
        return ce;
    }
    @Override
    @Transactional
    public Map<Integer, Float> getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = this.getAllContrats();
        Map<Integer,Float> map = new HashMap<>();
        float chiffreAffaire  = 0 ;
        System.out.println(contrats);
        Contrat  contrat = new Contrat();
        for (Contrat c : contrats) {

            Date datedebut = c.getDateDebutContrat();
            Date datefin = c.getDateFinContrat();
            System.out.println(c.getIdContrat());
            System.out.println(datedebut.after(startDate) + "/"+ datefin.before(endDate)+"/");
            try {
                if (datedebut.after(startDate) && datefin.before(endDate) ) {
                    if (c.getSpecialite().equals("IA")) {
                        map.put(Math.toIntExact(c.getIdContrat()),300f);
                    } else if (c.getSpecialite().name().equals("RESEAUX")) {
                        System.out.println(c.getSpecialite());
                        map.put(Math.toIntExact(c.getIdContrat()),350f);
                    } else if (c.getSpecialite().name().equals("CLOUD")) {
                        System.out.println(c.getSpecialite());
                        map.put(Math.toIntExact(c.getIdContrat()),400f);
                    } else if (c.getSpecialite().equals("SECURITE")) {
                        map.put(Math.toIntExact(c.getIdContrat()),450f);
                    }else {
                        System.out.println("no specialite");
                        map.put(Math.toIntExact(c.getIdContrat()),0f);
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("null");
            }

        }
        return map;
    }
@Override
@Transactional
    public Integer nbContratsValides(java.sql.Date startDate, java.sql.Date endDate) {
    List<Contrat> contrats = this.getAllContrats();
    int nbContratsValides = 0 ;
    for (Contrat c : contrats) {
        Date datedebut = c.getDateDebutContrat();
        Date datefin = c.getDateFinContrat();
        if (!c.getArchive()) {
            nbContratsValides++;
        }
    }
    return nbContratsValides;
    }
    @Override
    @Transactional
    @Scheduled(fixedRate = 3000)
        public String retrieveAndUpdateStatusContrat() throws Exception {
            List<Contrat> contrats = this.getAllContrats();
            List<String> contratsValides = new ArrayList<>();
            List<String> contratfini = new ArrayList<>();
            String contrat = "";
            String contratInfo = "" ;
            for (Contrat c : contrats) {
                try {
                    Date datefin = c.getDateFinContrat();
                    Date today = java.sql.Date.valueOf(java.time.LocalDate.now());
                    contratInfo = "Contrat [ " +"\n" +" ContratId :" + c.getIdContrat() + " \n" +
                            " dateFin : "+ datefin + " \n"+ " Etudiant : " +c.getEtudiant().getNomE() + " " +
                            "  " +c.getEtudiant().getPrenomE() + "\n"+" Specialite : " + c.getSpecialite() + " ] ";
                    if (c.getArchive()) {
                        if (datefin.getTime() - today.getTime() > 15) {
                            contratsValides.add(contratInfo);
                            contrat = contrat.concat("List de Contrat a revoir " + contratsValides.toString()+"\n");
                        }
                    }
                    boolean b = datefin.compareTo(today) == 0 && LocalDateTime.now().getHour() == 13;

                    if (b) {
                        contratfini.add(contratInfo);
                        contrat = contrat.concat("List de Contrat fini"+contratfini.toString());
                        c = this.getContratsById(Math.toIntExact(c.getIdContrat()));
                        c.setArchive(true);
                        this.saveOrUpdate(c);
                    }
                } catch (NullPointerException e) {
                    e.getCause();
                    // System.out.println("null");
                }
            }
            Thread.sleep(2000);
            System.out.println(contrat);
            return  contrat;
    }
}
