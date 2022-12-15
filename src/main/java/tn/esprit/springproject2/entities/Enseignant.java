package tn.esprit.springproject2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Enseignant")
public class Enseignant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnseignant")
    private long idEnseignant;
    private String prenomEnseignant;
    private String nomEnseignant;
    private String photoProfil;


    public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	@Temporal(TemporalType.DATE)
    private Date dateDebutFonction;
    @Enumerated(EnumType.STRING)
    private Grade grade;
    private double  salaire;
    @Enumerated(EnumType.STRING)
    private Matiere matiere;
    private long chargeHoraire;
    
    
    //@JsonBackReference("enseignant")
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Etudiant> etudiants;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="enseignant")
    private List<Equipe> equipes;


}
