package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.Contrat;
import tn.esprit.springproject2.entities.Departement;
import tn.esprit.springproject2.entities.Specialite;
import tn.esprit.springproject2.entities.Universite;
import tn.esprit.springproject2.repository.ContratRepository;
import tn.esprit.springproject2.repository.DepartementRepository;
import tn.esprit.springproject2.repository.UniversiteRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@Service
public class UniversiteServiceImp implements UniversiteService{
    UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    ContratRepository contratRepository;

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public void assignUniversiteToDepartment(long idUniversite, long idDepartment) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        Departement departement = departementRepository.findById(idDepartment).orElse(null);
        universite.getDepartements().add(departement);
        universiteRepository.save(universite);
    }

    //calculer le montant à payer par les universités entre deux dates triés par spécialité.

    /*@Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        float CA=0;
        List<Contrat> contrats = contratRepository.findContratByDateDebutContratAndDateFinContrat(startDate,endDate);
        for (int i=0; i<contrats.size() ;i++){
            Contrat ct=contrats.get(i);
            if (ct.isArchive()==true){
                CA=CA;
            }
            if (ct.getSpecialite().toString()=="IA"){
                int d = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int f = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA+=(f-d)*300;
            } else if (ct.getSpecialite().toString()=="RESEAUX") {
                int d = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int f = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA+=(f-d)*350;
            } else if (ct.getSpecialite().toString()=="CLOUD") {
                int d = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int f = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA+=(f-d)*400;
            } else if (ct.getSpecialite().toString()=="SECURITE"){
                int d = Integer.parseInt(ct.getDateDebutContrat().toString().substring(5,7));
                int f = Integer.parseInt(ct.getDateFinContrat().toString().substring(5,7));
                CA+=(f-d)*450;
            }
        }
        return CA;
    }*/
    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.getContratBetweenDates(startDate,endDate);
        LocalDate date1 = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        if (date1.isBefore(date2)
                && date2.getDayOfMonth() == date2.lengthOfMonth()
                && date1.getDayOfMonth() > date2.getDayOfMonth()) {
            monthsBetween += 1;
        }
        Contrat ct;
        long CA = 0;
        for (int i = 0; i <contrats.size();i++){
            ct  = contrats.get(i);
            if (ct.getSpecialite() == Specialite.IA){
                CA += monthsBetween*300;
            }
            if (ct.getSpecialite() == Specialite.CLOUD){
                CA += monthsBetween*400;
            }
            if (ct.getSpecialite() == Specialite.SECURITE){
                CA += monthsBetween*450;
            }
            if (ct.getSpecialite() == Specialite.RESEAUX){
                CA += monthsBetween*350;
            }
        }
        return CA;
    }

}
