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
}
