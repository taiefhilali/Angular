package tn.esprit.spring.atelierassociation.services;

import tn.esprit.spring.atelierassociation.entity.Contrat;
import tn.esprit.spring.atelierassociation.entity.Equipe;

import java.util.List;

public interface IEquipeService {
    public  Long Ajouter_equipe(Equipe equipe );

    void removeEquipe(Long idEquipe);

    List<Equipe> getAllEquipes();

    Equipe getEquipesById(int idEquipe);

    void saveOrUpdate(Equipe equipe);

    void updateequipe(Equipe equipes, int idEquipe);
}
