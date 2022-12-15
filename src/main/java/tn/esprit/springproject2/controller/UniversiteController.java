package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Option;
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


    /*@GetMapping("/findUnivByRegion/{region}")
    public  List<Universite>findUniversiteByRegion(@PathVariable("region") String region){
        return universiteService.findUniversiteByRegion(region);
    }
    @GetMapping("/getUniversiteByDepartementEtudiantOpt/{option}")
    public  List<Universite>getUniversiteByDepartementEtudiantOpt(@PathVariable("option") Option option){
        return universiteService.getUniversiteByDepartementEtudiantOpt(option);
    }
    @GetMapping("/getUniv")
    public ResponseEntity<List<Universite>> getAllUnivs(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "nomUniv") String sortBy)
    {
        List<Universite> list = universiteService.getAllUniv(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Universite>>(list, new HttpHeaders(), HttpStatus.OK);
    }*/
}
