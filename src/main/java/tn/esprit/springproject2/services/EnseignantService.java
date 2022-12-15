package tn.esprit.springproject2.services;


import tn.esprit.springproject2.entities.Enseignant;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Grade;
import tn.esprit.springproject2.entities.Matiere;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getAllEnseignants();
    Enseignant addEnseignant( Enseignant e);
    Enseignant updateEnseignant( Enseignant e);
    Enseignant getEnseignantById (long idEnseignant);
    void deleteEnseignant( long idEnseignant);
    Integer getNbrJoursById(Long id);
    List<Enseignant> updateSalaireAndGradeSelonDateDebutFonction();
    List<Enseignant> updateSalaireSelonChargeHoraire();
    Integer getDayById(Long id);
    List<Enseignant> findEnseignantByMatiere(Matiere m);
    Enseignant retrieveMeilleurEnseignantParMatiere(Matiere matiere1);

    Equipe affecterEnseignantToEquipe(long idEnseignant, String nomEquipe, Enseignant enseignant);

    void affecterPhotoToEnseignant(long idEnseignant, String photo);

    Integer getNbrEnseignantParGrade(String grade);

    List<Integer> getListStat();
}
