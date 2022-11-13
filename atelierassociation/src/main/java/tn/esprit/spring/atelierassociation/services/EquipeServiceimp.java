package tn.esprit.spring.atelierassociation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.atelierassociation.entity.Equipe;
import tn.esprit.spring.atelierassociation.repositeries.EquipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EquipeServiceimp  implements IEquipeService  {

    @Autowired
    EquipeRepository equipeRepository;


    public Long Ajouter_equipe(Equipe e) {
        equipeRepository.save(e);
        log.info("Ajouter equipe");
        return e.getIdEquipe();
    }

    @Override
    public void removeEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);

    }
    @Override
    public List<Equipe> getAllEquipes() {
        List<Equipe> equipes = new ArrayList<Equipe>();
        equipeRepository.findAll().forEach(contrats1 -> equipes.add(contrats1));
        return equipes;
    }
    @Override
    public Equipe getEquipesById(int idEquipe) {
        return equipeRepository.findById((long) idEquipe).get();

    }
    @Override
    public void saveOrUpdate(Equipe equipe) {
        equipeRepository.save(equipe);
    }
    @Override
    public void updateequipe(Equipe equipes, int idEquipe)
    {
        equipeRepository.save(equipes);
    }
}
