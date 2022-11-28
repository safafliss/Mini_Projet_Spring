package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Departement;
import tn.esprit.springproject2.entities.Option;
import tn.esprit.springproject2.services.DepartementService;

import java.util.List;
@AllArgsConstructor
@RestController
public class DepartementController {

    DepartementService departementService;

    @GetMapping("/getDepartements")
    public List<Departement> getAllDepartement(){
        return departementService.getAllDepartement();
    }

    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }

    @PutMapping("/updateDepartement")
    public Departement updateDepartement(@RequestBody Departement updDepartement){
        return departementService.updateDepartement(updDepartement);
    }

    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementById(@PathVariable Long id){
        return departementService.getDepartementById(id);
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public void deleteDepartement(@PathVariable Long id){
        departementService.deleteDepartement(id);
    }

    @GetMapping("/retrieveDepartementByOptionEtudiant/{op}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable("op") Option op){
        return departementService.retrieveDepartementByOptionEtudiant(op);
    }

    @GetMapping("/retrieveDepartmentByUniversite/{idUniversite}")
    public List<Departement> retrieveDepartmentByUniversite(@PathVariable("idUniversite") long idUniversite){
        return departementService.retrieveDepartmentByUniversite(idUniversite);
    }
}
