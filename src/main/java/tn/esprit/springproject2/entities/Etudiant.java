package tn.esprit.springproject2.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    //@JsonIgnore(mahdi)
    private Set<Contrat> contrats;
    //cascadetype tjs fils
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="etudiants")
    private Set<Equipe> equipes;
}
