package tn.esprit.springproject2.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private long idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    private float note;
    //private static Map<String, Double> notes;
            /*= new HashMap<>();
    static{
        map.put("A",2.0);
        map.put("B",3.0);
        System.out.println(map);
    }*/


    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;
    //cascadetype tjs fils
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="etudiants")
    @JsonIgnore
    private Set<Equipe> equipes;

    //Enseignant
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
    private List<Enseignant> enseignants;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    private List<Notes> notes;

}
