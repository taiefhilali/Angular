package tn.esprit.spring.atelierassociation.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.atelierassociation.entity.Etudiant;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository  extends JpaRepository<Etudiant,Long> {
    //List<Etudiant> findBynomE(String nomE);

    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);
}