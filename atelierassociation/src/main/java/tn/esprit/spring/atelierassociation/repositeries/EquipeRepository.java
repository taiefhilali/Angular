package tn.esprit.spring.atelierassociation.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Equipe;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    List<Equipe> findByIdEquipe(Long equipeId);
}

