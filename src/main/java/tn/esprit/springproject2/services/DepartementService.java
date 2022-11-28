package tn.esprit.springproject2.services;

import tn.esprit.springproject2.entities.Departement;
import tn.esprit.springproject2.entities.Option;

import java.util.List;

public interface DepartementService {
    List<Departement> getAllDepartement();
    Departement addDepartement( Departement d);
    Departement updateDepartement( Departement d);
    Departement getDepartementById (Long idDepartement);
    void deleteDepartement( Long idDepartement);
    List<Departement> retrieveDepartementByOptionEtudiant(Option op);
    //récupérer le ou les départements d’une université donnée.
    List<Departement> retrieveDepartmentByUniversite(long idUniversite);
}
