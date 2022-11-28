package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.Contrat;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.repository.ContratRepository;
import tn.esprit.springproject2.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class ContratServiceImp implements ContratService{

    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getContratById(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void deleteContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Contrat contrat = this.contratRepository.findById(ce.getIdContrat()).orElse(null);
        Etudiant etudiant = this.etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        if (etudiant.getContrats().size()<5) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }
        return contrat;
    }

    /*@Override
    public List<Contrat> findContratByDateDebutContratAndDateFinContrat(Date dateDebutContrat, Date dateFinContrat) {
        return contratRepository.findContratByDateDebutContratAndDateFinContrat(dateDebutContrat,dateFinContrat);
    }*/

    @Override
    public List<Contrat> getContratBetweenDates(Date startDate, Date endDate) {
        return contratRepository.getContratBetweenDates(startDate,endDate);
    }


    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.getContratBetweenDates(startDate,endDate);
        int nb = 0;
        for (int i=0; i<contrats.size();i++){
            Contrat ct = contrats.get(i);
            if (ct.isArchive()==false){
                nb++;
            }
        }
        return nb;
    }

}
