package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
    //Afficher la liste des equipes qui ont une thematique précise.
    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);

    //Afficher la liste des equipes d’un étudiant.
    List<Equipe> findEquipeByEtudiantsIdEtudiant(long id);

    //Afficher la liste des equipes d’un etudiant  dont la thematique est non nulle
    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (long idEtudiant);

    //Afficher la liste des equpes par etudiant et departement.
    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (long idEtudiant, long idDepart);

    //Afficher les équipes selon un niveau donné et une thématique donnée
    @Query("select e FROM Equipe e, DetailEquipe de where e.idEquipe = de.idDetailEquipe and e.niveau = ?1 and de.thematique = ?2 ")
    List<Equipe> retriveEquipeByNiveauAndThematique (Niveau niveau , String thematique);

    //Supprimer une equipe selon niveau
    @Modifying
    @Transactional
    @Query("DELETE FROM Equipe eq WHERE eq.niveau= ?1")
    void deleteEquipeByNiveau( Niveau niveau);

}
