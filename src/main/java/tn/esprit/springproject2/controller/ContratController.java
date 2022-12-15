package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Contrat;
import tn.esprit.springproject2.services.ContratService;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContratController {

    ContratService contratService;

    @GetMapping("/getContrats")
    public List<Contrat> getAllContrat() {
        return contratService.getAllContrat();
    }

    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat updContrat) {
        return contratService.updateContrat(updContrat);
    }

    @GetMapping("/getContratById/{id}")
    public Contrat getContratById(@PathVariable("id") Long id) {
        return contratService.getContratById(id);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") Long id) {
        contratService.deleteContrat(id);
    }

    @PutMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable("nomE") String nomE, @PathVariable("prenomE") String prenomE) {
        return contratService.affectContratToEtudiant(ce, nomE, prenomE);
    }

    /*@GetMapping("/findContratByDateDebutContratAndDateFinContrat/{dateDebutContrat}/{dateFinContrat}")
    public List<Contrat> findContratByDateDebutContratAndDateFinContrat(@PathVariable("dateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebutContrat, @PathVariable("dateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateFinContrat) {
        return contratService.findContratByDateDebutContratAndDateFinContrat(dateDebutContrat, dateFinContrat);
    }*/

    @GetMapping("getContratBetweenDates/{startDate}/{endDate}")
    public List<Contrat> getContratBetweenDates(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return contratService.getContratBetweenDates(startDate,endDate);
    }

    @GetMapping("/nbContratsValides/{startDate}/{endDate}")
    public Integer nbContratsValides(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratService.nbContratsValides(startDate,endDate);
    }
    @GetMapping("/getNbrjourById/{id}")
    public Integer getNbrjourById(@PathVariable("id") Long id){
        return contratService.getNbrjourById(id);
    }


    @PostMapping("/affectContratToEtudiantById/{id}")
    public Contrat affectContratToEtudiantById(@RequestBody Contrat ce,@PathVariable("id") long id){
        return contratService.affectContratToEtudiantById(ce,id);
    }
}
