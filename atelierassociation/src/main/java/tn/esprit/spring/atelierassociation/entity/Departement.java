package tn.esprit.spring.atelierassociation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Table( name="Departement")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDepart")
    private Long idDepart; // ClÃ© primaire
    private String nomDepart;


    //@ManyToOne
    @OneToMany(mappedBy = "dept")
   private List<Etudiant> etuds;


}
