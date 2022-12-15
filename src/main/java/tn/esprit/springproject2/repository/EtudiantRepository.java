package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.entities.Option;

import javax.transaction.Transactional;
import java.util.List;

public interface EtudiantRepository extends JpaRepository <Etudiant, Long> {
    Etudiant findByPrenomE(String prenomE);

    /* Afficher les etudiants qui travaillent sur une thematique donnée */
    @Query("SELECT e FROM Etudiant e join e.equipes eq join eq.detailEquipe de where  de.thematique = :thematique")
    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);

    /* Mettre à jour l'option d'un étudiant */
    @Modifying
    @Transactional
    @Query("update Etudiant e set e.option = ?1 where e.idEtudiant = ?2")
    void updateEtudiantByOption(Option op , Long idEtudiant);

    @Query("select e from Etudiant e where e.nomE = ?1 and e.prenomE = ?2")
    Etudiant findEtudiantByNomEAndPrenomE(String nomE, String prenomE);

    @Query("SELECT e.idEtudiant FROM Etudiant e join e.equipes eq join eq.enseignant en where  en.idEnseignant = :idEnseignant and eq.nomEquipe = :nom")
    List<Integer> findListEtudiantsByEquipeAndEnseignant(long idEnseignant, String nom);

    @Query("SELECT concat(e.nomE, ' ', e.prenomE) FROM Etudiant e join e.equipes eq join eq.enseignant en where  en.idEnseignant = :idEnseignant and eq.nomEquipe = :nom")
    List<String> findListEtudiantsByEquipeAndEnseignant2(long idEnseignant, String nom);





    List<Etudiant> findByEquipes_IdEquipe(Long idEquipe);
}
