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
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idUniv;
    private String adresse;
    private String description;
    private String nomUniv;
    private String region;
    private  String imgUrl;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Departement> departements;

    //Enseignant
    @OneToMany(cascade = CascadeType.ALL)
    private List<Enseignant> enseignants;
}
