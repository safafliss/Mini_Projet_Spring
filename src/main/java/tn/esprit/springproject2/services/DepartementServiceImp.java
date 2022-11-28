package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.Departement;
import tn.esprit.springproject2.entities.Option;
import tn.esprit.springproject2.entities.Universite;
import tn.esprit.springproject2.repository.DepartementRepository;
import tn.esprit.springproject2.repository.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class DepartementServiceImp implements DepartementService{

    DepartementRepository departementRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement getDepartementById(Long idDepartement) {
        return departementRepository.findById(idDepartement).orElse(null);
    }

    @Override
    public void deleteDepartement(Long idDepartement) {
        departementRepository.deleteById(idDepartement);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }

    @Override
    public List<Departement> retrieveDepartmentByUniversite(long idUniversite) {
        Universite universite = this.universiteRepository.findById(idUniversite).orElse(null);
        List<Departement> l = new ArrayList<Departement>();
        l.addAll(universite.getDepartements());
        return l;
    }
}
