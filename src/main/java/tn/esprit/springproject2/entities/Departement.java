package tn.esprit.springproject2.entities;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepart;
    private String nomDepart;
    private String type;
    private String description;
    private String Universite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
    private Set<Etudiant> Etudiants;


    //Enseignant
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private List<Enseignant> enseignants;


}
