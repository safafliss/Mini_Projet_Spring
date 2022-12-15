package tn.esprit.springproject2.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe, Long>,PagingAndSortingRepository<Equipe,Long> {
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

    List<Equipe> findEquipeByEnseignantIdEnseignant(long idEnseignant);

    @Query("select e.nomEquipe from Equipe e where e.enseignant.idEnseignant = ?1")
    List<String> findEquipeNomEquipeByEnseignantIdEnseignant(long idEnseignant);

    @Query("SELECT eq.nomEquipe FROM Equipe eq")
    List<String> findListEquipe();

    Equipe findEquipeByNomEquipe(String nomEquipe);
    @Query("select e.nomEquipe from Equipe e where e.enseignant.idEnseignant <> ?1")
    List<String> findAutresEquipes(long idEnseignant);





    Equipe findEquipeByIdEquipe(Long idEquipe);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByNiveau(Niveau niveau);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);

    @Query("SELECT eq FROM Equipe eq WHERE " +
            "eq.nomEquipe LIKE CONCAT('%',:query, '%')")
    List<Equipe> searchEquipes(String query);

    @Query(value = "SELECT eq FROM Equipe eq")
    List<Equipe> findAllAsc(Sort sort);

    @Query(value = "SELECT eq FROM Equipe eq")
    List<Equipe> findAllDesc(Sort sort);

}
