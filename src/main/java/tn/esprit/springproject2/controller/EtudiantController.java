package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.entities.Option;
import tn.esprit.springproject2.services.EtudiantService;

import java.util.List;
@AllArgsConstructor
@RestController
public class EtudiantController {
    EtudiantService etudiantService;


    @GetMapping("/getEtudiants")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant updEtudiant){
        return etudiantService.updateEtudiant(updEtudiant);
    }

    @GetMapping("/getEtudiantById/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id){
        return etudiantService.getEtudiantById(id);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id){
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/findByPrenomE/{prenomE}")
    public Etudiant findByPrenomE(@PathVariable("prenomE") String prenomE){
        return etudiantService.findByPrenomE(prenomE);
    }

    @GetMapping("/retrieveEtudiantByEquipeThematique/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique (@PathVariable("thematique") String thematique){
        return etudiantService.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/updateEtudiantByOption/{op}/{idEtudiant}")
    void updateEtudiantByOption(@PathVariable("op") Option op ,@PathVariable("idEtudiant") Long idEtudiant){
        etudiantService.updateEtudiantByOption(op,idEtudiant);
    }

    @PutMapping("/assignEtudiantToDepartment/{idEtudiant}/{idDepartment}")
    public void assignEtudiantToDepartment(@PathVariable("idEtudiant") long idEtudiant,@PathVariable("idDepartment") long idDepartment){
        etudiantService.assignEtudiantToDepartment(idEtudiant,idDepartment);
    }

    @GetMapping("/findEtudiantByNomEAndPrenomE/{nomE}/{prenomE}")
    public Etudiant findEtudiantByNomEAndPrenomE(@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE){
        return etudiantService.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }

    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    //@PostMapping
    //@ResponseBody
    public Etudiant addAndAssignEtudiantToEquipeAndContract( @RequestBody Etudiant e,@PathVariable("idContrat") long idContrat,@PathVariable("idEquipe") long idEquipe){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @GetMapping("/getEtudiantsByDepartment/{idDepartment}")
    public List<Etudiant> getEtudiantsByDepartment (@PathVariable("idDepartment") long idDepartment){
        return etudiantService.getEtudiantsByDepartment(idDepartment);
    }
}
