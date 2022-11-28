package tn.esprit.springproject2.entities;
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
@Table( name = "Universite")
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUni;
    private String nomUni;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
}
