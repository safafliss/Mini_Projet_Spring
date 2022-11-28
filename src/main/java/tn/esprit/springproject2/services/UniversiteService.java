package tn.esprit.springproject2.services;
import tn.esprit.springproject2.entities.Universite;

import java.util.Date;
import java.util.List;

public interface UniversiteService {
    List<Universite> getAllUniversite();
    Universite addUniversite( Universite u);
    Universite updateUniversite( Universite u);
    Universite getUniversiteById (Long idUniversite);
    void deleteUniversite( Long idUniversite);
    //affecter une université à un département.
    void assignUniversiteToDepartment(long idUniversite, long idDepartment);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
}
