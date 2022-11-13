package tn.esprit.spring.atelierassociation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name="Contrat")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idContrat")
 private Long idContrat; // ClÃ© primaire
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    private Boolean archive;
    private int montantContrat;


 @ManyToOne(cascade =CascadeType.ALL)
 private Etudiant etudiant;



}
