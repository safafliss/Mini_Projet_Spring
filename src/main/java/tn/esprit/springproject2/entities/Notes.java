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
@Table( name = "Notes")
public class Notes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNotes")
    private long idNotes;
    @Enumerated(EnumType.STRING)
    private Matiere matiere;
    private double note;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Etudiant etudiant;

}
