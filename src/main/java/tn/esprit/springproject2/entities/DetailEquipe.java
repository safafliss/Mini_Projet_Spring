package tn.esprit.springproject2.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "DetailEquipe")
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailEquipe;
    private Long salle;
    private String thematique;
    @OneToOne(mappedBy="detailEquipe")
    @JsonIgnore
    private Equipe equipe;
}
