package tn.esprit.spring.atelierassociation.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.atelierassociation.entity.Departement;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
   // List<Departement> findByNomDepartContains(String NomDepart);
}
