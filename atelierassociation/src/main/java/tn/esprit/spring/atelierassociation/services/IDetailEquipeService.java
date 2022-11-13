package tn.esprit.spring.atelierassociation.services;

import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {


    Long Ajouter_detailequipe(DetailEquipe detailEquipe);

    void removeDetailequipe(Long idDeatilEquipe);

    List<DetailEquipe> getAlldetailsequipes();

    DetailEquipe getdetailsequipesById(int idDeatilEquipe);

    void saveOrUpdate(DetailEquipe detailEquipes);

    void updatecontrat(DetailEquipe detailEquipes, int idDeatilEquipe);
}
