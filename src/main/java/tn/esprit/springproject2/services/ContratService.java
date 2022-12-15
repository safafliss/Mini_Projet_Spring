package tn.esprit.springproject2.services;

import tn.esprit.springproject2.entities.Contrat;


import java.util.Date;
import java.util.List;

public interface ContratService {
    List<Contrat> getAllContrat();
    Contrat addContrat( Contrat c);
    Contrat updateContrat( Contrat c);
    Contrat getContratById (Long idContrat);
    void deleteContrat( Long idContrat);
    //affecter un contrat à un étudiant en vérifiant que l’étudiant n’a pas dépassé la limite autorisée de 5 contrats actifs.
    Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
    //List<Contrat> findContratByDateDebutContratAndDateFinContrat(Date dateDebutContrat, Date dateFinContrat);
    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);
    //calculer le nombre de contrats encore valides entre deux dates.
    Integer nbContratsValides(Date startDate, Date endDate);

    Integer getNbrjourById(Long id);

    public Contrat affectContratToEtudiantById(Contrat ce, long id);
}
