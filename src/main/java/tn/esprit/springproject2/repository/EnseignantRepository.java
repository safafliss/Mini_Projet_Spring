package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.Enseignant;
import tn.esprit.springproject2.entities.Grade;
import tn.esprit.springproject2.entities.Matiere;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
    @Query(nativeQuery = true, value= "SELECT DATEDIFF(CAST( NOW() AS Date ), en.date_debut_fonction) AS DateDiff from Enseignant as en  where en.id_enseignant = ?1 ")
    Integer getNbrJoursById(Long id);

    @Query(nativeQuery = true, value = "SELECT DAY(CAST( NOW() AS Date )) AS jour from Enseignant as en  where en.id_enseignant = ?1 ")
    Integer getDayById(Long id);

    List<Enseignant> findEnseignantByMatiere(Matiere m);

    @Query(nativeQuery = true, value= "select count(*) from enseignant AS e where e.grade = ?1")
    Integer getNbrEnseignantParGrade(String grade);
}
