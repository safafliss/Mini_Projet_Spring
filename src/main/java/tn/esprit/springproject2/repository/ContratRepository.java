package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository <Contrat , Long> {
    //List<Contrat> findContratByDateDebutContratAndDateFinContrat(Date dateDebutContrat, Date dateFinContrat);
    @Query("SELECT ct FROM Contrat ct where (?1 between ct.dateDebutContrat and ct.dateFinContrat) and (?2 between ct.dateDebutContrat and ct.dateFinContrat)")
    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);

    @Query(nativeQuery = true, value= "SELECT DATEDIFF( ct.date_fin_contrat,CAST( NOW() AS Date )) AS DateDiff from Contrat as ct  where ct.id_contrat = ?1 ")
    Integer getNbrjourById(Long id);
}
