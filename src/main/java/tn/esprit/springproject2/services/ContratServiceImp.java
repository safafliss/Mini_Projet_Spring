package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.Contrat;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.repository.ContratRepository;
import tn.esprit.springproject2.repository.EtudiantRepository;

import javax.transaction.Transactional;
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

    @Override
    public Integer getNbrjourById(Long id) {
        return contratRepository.getNbrjourById(id);
    }


    @Scheduled(cron = "* 56 10 * * *")
    public String retrieveAndUpdateStatusContrat(){
        List<Contrat> contrats= contratRepository.findAll();
        contrats.forEach(contrat -> {
            if (contratRepository.getNbrjourById(contrat.getIdContrat())<=0 && !contrat.isArchive()){
                contrat.setArchive(true);
                contratRepository.save(contrat);
                System.out.println("Le contrat: " + contrat.getIdContrat() + " est archivé");
            } else if (contratRepository.getNbrjourById(contrat.getIdContrat())<=15 && contratRepository.getNbrjourById(contrat.getIdContrat())>0) {
                System.out.println("le contrat: " + contrat.getIdContrat() + "\n de specialité : " + contrat.getSpecialite() + "\n attribué à l'étudiant: "
                        + contrat.getEtudiant().getIdEtudiant() + "n'est pas encore archivé");
            }
        });
        return "";
    }

    @Override
    @Transactional
    public Contrat affectContratToEtudiantById(Contrat ce, long id) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        ce.setEtudiant(etudiant);
        contratRepository.save(ce);
        return ce;
    }

}
