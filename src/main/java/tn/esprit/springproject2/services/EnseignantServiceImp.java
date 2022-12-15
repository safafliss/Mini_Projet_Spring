package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.*;
import tn.esprit.springproject2.repository.EnseignantRepository;
import tn.esprit.springproject2.repository.EquipeRepository;
import tn.esprit.springproject2.repository.EtudiantRepository;


import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class EnseignantServiceImp implements EnseignantService{
    EnseignantRepository enseignantRepository;
    EtudiantRepository etudiantRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant addEnseignant(Enseignant e) {
        System.out.println("saved");
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant updateEnseignant(Enseignant e) {
        return enseignantRepository.save(e);
    }

    @Override
    public Enseignant getEnseignantById(long idEnseignant) {
        return enseignantRepository.findById(idEnseignant).orElse(null);
    }

    @Override
    public void deleteEnseignant(long idEnseignant) {
        enseignantRepository.deleteById(idEnseignant);
    }


    /**/
    @Override
    public Integer getNbrJoursById(Long id) {
        return enseignantRepository.getNbrJoursById(id);
    }

    @Override
    public List<Enseignant> updateSalaireAndGradeSelonDateDebutFonction() {
        List<Enseignant> enseignants = this.enseignantRepository.findAll();
        enseignants.forEach(enseignant -> {
            if(enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 <= 2){
                enseignantRepository.save(enseignant);
            } else if(enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 >2 && enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 <=3){
                enseignant.setGrade(Grade.C);
                enseignant.setSalaire(2000);
                enseignantRepository.save(enseignant);
            } else if(enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 >3 && enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 <=5){
                enseignant.setGrade(Grade.B);
                enseignant.setSalaire(3000);
                enseignantRepository.save(enseignant);
            }else if(enseignantRepository.getNbrJoursById(enseignant.getIdEnseignant())/365 >5){
                enseignant.setGrade(Grade.A);
                enseignant.setSalaire(3500);
                enseignantRepository.save(enseignant);
            }

        });
        return enseignantRepository.findAll();
    }

    @Override
    public Integer getDayById(Long id) {
        return enseignantRepository.getDayById(id);
    }

    @Override
    public List<Enseignant> updateSalaireSelonChargeHoraire() {
        List<Enseignant> enseignants = this.enseignantRepository.findAll();
        enseignants.forEach(enseignant -> {
            if(enseignantRepository.getDayById(enseignant.getIdEnseignant()) == 12 && enseignant.getChargeHoraire()==60){
                enseignantRepository.save(enseignant);
            }else if(enseignantRepository.getDayById(enseignant.getIdEnseignant())== 12 && enseignant.getChargeHoraire()>60){
                if(enseignant.getGrade()==Grade.D){
                    enseignant.setSalaire(1500 + ((enseignant.getChargeHoraire() - 60)* (25 + 3)));
                    enseignantRepository.save(enseignant);
                } else if(enseignant.getGrade()==Grade.C){
                    enseignant.setSalaire(2000 + ((enseignant.getChargeHoraire() - 60)* (33.3 + 5)));
                    enseignantRepository.save(enseignant);
                }else if(enseignant.getGrade()==Grade.B){
                    enseignant.setSalaire(3000 + ((enseignant.getChargeHoraire() - 60)* (50 + 8)));
                    enseignantRepository.save(enseignant);
                }else if(enseignant.getGrade()==Grade.A){
                    enseignant.setSalaire(3500 + ((enseignant.getChargeHoraire() - 60)* (58.3 + 10)));
                    enseignantRepository.save(enseignant);
                }
            }else if(enseignantRepository.getDayById(enseignant.getIdEnseignant())== 12 && enseignant.getChargeHoraire()<60){
                if(enseignant.getGrade()==Grade.D){
                    enseignant.setSalaire(1500 - ((60 - enseignant.getChargeHoraire())* 25));
                    enseignantRepository.save(enseignant);
                } else if(enseignant.getGrade()==Grade.C){
                    enseignant.setSalaire(2000 - ((60 - enseignant.getChargeHoraire())* 33.3));
                    enseignantRepository.save(enseignant);
                }else if(enseignant.getGrade()==Grade.B){
                    enseignant.setSalaire(3000 - ((60 - enseignant.getChargeHoraire())* 50));
                    enseignantRepository.save(enseignant);
                }else if(enseignant.getGrade()==Grade.A){
                    enseignant.setSalaire(3500 - ((60 - enseignant.getChargeHoraire())* 58.3));
                    enseignantRepository.save(enseignant);
                }
            }
        });
        return enseignantRepository.findAll();
    }


    @Override
    public List<Enseignant> findEnseignantByMatiere(Matiere m) {
        return enseignantRepository.findEnseignantByMatiere(m);
    }

    @Override
    public Enseignant retrieveMeilleurEnseignantParMatiere(Matiere matiere1) {
        List<Enseignant> enseignants = this.enseignantRepository.findEnseignantByMatiere(matiere1);
        List<Double> listMoy = new ArrayList<>();
        for(int j=0; j<enseignants.size();j++){
            List<Etudiant> l = enseignants.get(j).getEtudiants();
            double moy = 0;
            for(int k=0;k<l.size();k++){
                List<Notes> notes = l.get(k).getNotes();
                for(int i=0; i<notes.size();i++){
                    if(notes.get(i).getMatiere()== matiere1){
                        moy = moy + notes.get(i).getNote();
                    }
                }
            }
            moy = moy/ l.size();
            listMoy.add(moy);
        }
        int index =0;
        double moyMax = listMoy.get(0);
        for(int i=0; i<listMoy.size(); i++){
            if(listMoy.get(i)>moyMax){
                moyMax= listMoy.get(i);
                index = i;
            }
        }
        return enseignants.get(index);
    }



    /**/
    @Override
    public Equipe affecterEnseignantToEquipe(long idEnseignant, String nomEquipe, Enseignant enseignant) {
        Enseignant e = this.enseignantRepository.findById(idEnseignant).orElse(null);
        Equipe equipe = this.equipeRepository.findEquipeByNomEquipe(nomEquipe);
        equipe.setEnseignant(e);
        equipeRepository.save(equipe);
        return equipe;
    }

    @Override
    public void affecterPhotoToEnseignant(long idEnseignant, String photo) {
        Enseignant enseignant = this.enseignantRepository.findById(idEnseignant).orElse(null);
        enseignant.setPhotoProfil(photo);
        enseignantRepository.save(enseignant);
    }

    @Override
    public Integer getNbrEnseignantParGrade(String grade) {
        return enseignantRepository.getNbrEnseignantParGrade(grade);
    }

    @Override
    public List<Integer> getListStat() {
        List<Integer> list = new ArrayList<>();
        list.add(getNbrEnseignantParGrade("A"));
        list.add(getNbrEnseignantParGrade("B"));
        list.add(getNbrEnseignantParGrade("C"));
        list.add(getNbrEnseignantParGrade("D"));
        return list;
    }


    @Scheduled(fixedRate = 60000)
    public void fixedRateMethod(){
        System.out.println("Method with fixed Rate");
    }



}
