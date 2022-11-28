package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.*;
import tn.esprit.springproject2.repository.ContratRepository;
import tn.esprit.springproject2.repository.DepartementRepository;
import tn.esprit.springproject2.repository.EquipeRepository;
import tn.esprit.springproject2.repository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.*;

@AllArgsConstructor
@Service
public class EtudiantServiceImp implements EtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant findByPrenomE(String prenomE) {
        return  etudiantRepository.findByPrenomE(prenomE);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

   @Override
    public void updateEtudiantByOption(Option op, Long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op,idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartment(long idEtudiant, long idDepartment) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = this.departementRepository.findById(idDepartment).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant findEtudiantByNomEAndPrenomE(String nomE, String prenomE) {
        return etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }

    @Override
    @Transactional //modification sur plusieurs tables
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, long idContrat, long idEquipe) {
        Contrat contrat = this.contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = this.equipeRepository.findById(idEquipe).orElse(null);
        equipe.getEtudiants().add(e);
        contrat.setEtudiant(e);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartment(long idDepartment) {
        Departement departement = this.departementRepository.findById(idDepartment).orElse(null);
        List<Etudiant> l = new ArrayList<Etudiant>();
        l.addAll(departement.getEtudiants());
        return l;
    }


}
