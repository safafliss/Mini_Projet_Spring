package tn.esprit.springproject2.services;

import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;

import java.util.List;

public interface EquipeService {
    List<Equipe> getAllEquipe();
    Equipe addEquipe( Equipe eq);
    Equipe updateEquipe( Equipe eq);
    Equipe getEquipeById (Long idEquipe);
    void deleteEquipe( Long idEquipe);
    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th);
    List<Equipe> findEquipeByEtudiantsIdEtudiant(long id);
    List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (long idEtudiant);
    List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (long idEtudiant, long idDepart);
    List<Equipe> retriveEquipeByNiveauAndThematique (Niveau niveau , String thematique);
    void deleteEquipeByNiveau( Niveau niveau);
    List<Equipe> findEquipeByEnseignantIdEnseignant(long idEnseignant);
    List<String> findEquipeNomEquipeByEnseignantIdEnseignant(long idEnseignant);
    List<String> findListEquipe();
    Equipe findEquipeByNomEquipe(String nomEquipe);
    List<String> findAutresEquipes(long idEnseignant);




    List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant,Long idDepart);
    // void faireEvoluerEquipes();
    public float getMoyenneEquipe(Long idEquipe);
    int getNbrEtudiantparEquipe(Long idEquipe);
    public List<Equipe> getAllEquipes(Integer pageNo, Integer pageSize, String sortBy);
    public List<Equipe>getAllAsc();
    public List<Equipe>getAllDesc();

    List<Equipe> searchEquipes(String query);

    public void assignEtudianttoEquipe(Long idEquipe,Long idEtudiant);

}
