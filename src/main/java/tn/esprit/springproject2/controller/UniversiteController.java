package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Universite;
import tn.esprit.springproject2.services.DepartementService;
import tn.esprit.springproject2.services.UniversiteService;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@RestController
public class UniversiteController {
    UniversiteService universiteService;

    @GetMapping("/getUniversites")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite updUniversite){
        return universiteService.updateUniversite(updUniversite);
    }

    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteById(@PathVariable Long id){
        return universiteService.getUniversiteById(id);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable Long id){
        universiteService.deleteUniversite(id);
    }

    @PutMapping("/assignUniversiteToDepartment/{idUniversite}/{idDepartment}")
    public void assignUniversiteToDepartment(@PathVariable("idUniversite") long idUniversite,@PathVariable("idDepartment") long idDepartment){
        universiteService.assignUniversiteToDepartment(idUniversite,idDepartment);
    }
    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return universiteService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
}
