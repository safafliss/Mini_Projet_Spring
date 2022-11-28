package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.Departement;
import tn.esprit.springproject2.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    //Récuperer les departements qui ont un étudiant avec Option donné
    @Query("select d FROM Departement d, Etudiant e where d.idDepart = e.departement.idDepart and e.option = ?1 ")
    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

}
