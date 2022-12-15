package tn.esprit.springproject2.services;

import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.entities.Option;

import java.util.List;

public interface EtudiantService {

    List<Etudiant> getAllEtudiant();
    Etudiant addEtudiant( Etudiant e);
    Etudiant updateEtudiant( Etudiant e);
    Etudiant getEtudiantById (Long idEtudiant);
    void deleteEtudiant( Long idEtudiant);
    Etudiant findByPrenomE(String prenomE);
    List<Etudiant> retrieveEtudiantByEquipeThematique (String thematique);
    void updateEtudiantByOption(Option op , Long idEtudiant);
    //affecter un étudiant à un département.
    public void assignEtudiantToDepartment( long idEtudiant, long idDepartment);
    Etudiant findEtudiantByNomEAndPrenomE(String nomE, String prenomE);
    //ajouter et affecter un étudiant à une équipe et un contrat en utilisant une seule méthode.
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe);
    //récupérer les étudiants d’un département donné.
    List<Etudiant> getEtudiantsByDepartment (long idDepartment);
    List<Integer> findListEtudiantsByEquipeAndEnseignant(long idEnseignant, String nom);
    List<String> findListEtudiantsByEquipeAndEnseignant2(long idEnseignant, String nom);




}
