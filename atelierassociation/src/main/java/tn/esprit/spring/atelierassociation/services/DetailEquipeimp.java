package tn.esprit.spring.atelierassociation.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.atelierassociation.entity.DetailEquipe;
import tn.esprit.spring.atelierassociation.repositeries.DetailEquipeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DetailEquipeimp implements IDetailEquipeService  {

    @Autowired
    DetailEquipeRepository detailEquipeRepository;

    @Override
    public Long Ajouter_detailequipe(DetailEquipe detailEquipe) {
        detailEquipeRepository.save(detailEquipe);
        log.info("Ajouter detailequipe");
        return detailEquipe.getIdDeatilEquipe();
    }
    @Override
    public void removeDetailequipe(Long idDeatilEquipe) {
        detailEquipeRepository.deleteById(idDeatilEquipe);

    }
    @Override
    public List<DetailEquipe> getAlldetailsequipes() {
        List<DetailEquipe> detailEquipes = new ArrayList<DetailEquipe>();
        detailEquipeRepository.findAll().forEach(contrats1 -> detailEquipes.add(contrats1));
        return detailEquipes;
    }
    @Override
    public DetailEquipe getdetailsequipesById(int idDeatilEquipe) {
        return detailEquipeRepository.findById((long) idDeatilEquipe).get();

    }
    @Override
    public void saveOrUpdate(DetailEquipe detailEquipes) {
        detailEquipeRepository.save(detailEquipes);
    }
    @Override
    public void updatecontrat(DetailEquipe detailEquipes, int idDeatilEquipe)
    {
        detailEquipeRepository.save(detailEquipes);
    }
}
