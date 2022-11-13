package tn.esprit.spring.atelierassociation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name="Equipe")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Equipe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private Long idEquipe; // ClÃ© primaire

    @Enumerated(EnumType.STRING)
    Niveau niveau;
    private String NomEquipe;
    @OneToOne
    private DetailEquipe detailEquipe;
@ManyToMany
private List<Etudiant> etudiants;

}
