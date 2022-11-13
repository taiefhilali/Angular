
package tn.esprit.spring.atelierassociation.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table( name="Etudiant")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Slf4j

public class Etudiant implements Serializable {

    @Enumerated(EnumType.STRING)
    Option opt;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // ClÃ© primaire
    private String prenomE;
    private String nomE;
    @Temporal(TemporalType.DATE)
     private Date d;
    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL)
    private List<Contrat> cntrats;
    @ManyToOne
    private Departement dept;
    @ManyToMany(mappedBy ="etudiants")
    private List<Equipe> Equips;
    


// Constructeur et accesseurs (getters) et mutateurs (setters)




}
