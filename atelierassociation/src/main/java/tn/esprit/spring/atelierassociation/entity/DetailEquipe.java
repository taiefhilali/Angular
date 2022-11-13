package tn.esprit.spring.atelierassociation.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table( name="DetailEquipe")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDeatilEquipe")
    private Long idDeatilEquipe; // ClÃ© primaire

    private int salle;
    private String thematique;

    public Long getIdDeatilEquipe() {
        return idDeatilEquipe;
    }

  @OneToOne(mappedBy = "detailEquipe")
  private Equipe equiped;





}
