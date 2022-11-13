package tn.esprit.spring.atelierassociation.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.atelierassociation.entity.Departement;
import tn.esprit.spring.atelierassociation.entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
