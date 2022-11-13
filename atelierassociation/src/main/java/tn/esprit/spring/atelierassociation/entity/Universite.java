package tn.esprit.spring.atelierassociation.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table( name="Universite")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUniv")
    private Long idUniv; // ClÃ© primaire
    private String nomUniv;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> dpts;




}
