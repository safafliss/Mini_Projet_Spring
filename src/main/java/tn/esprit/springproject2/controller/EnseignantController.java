package tn.esprit.springproject2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.springproject2.entities.Enseignant;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Grade;
import tn.esprit.springproject2.entities.Matiere;
import tn.esprit.springproject2.services.EnseignantService;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;


import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EnseignantController {
    EnseignantService enseignantService;

    @GetMapping("/getAllEnseignants")
    public List<Enseignant> getAllEnseignants(){
        return enseignantService.getAllEnseignants();
    }

    
    @PostMapping("/addEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant enseignant){
        return enseignantService.addEnseignant(enseignant);
    }

    @PutMapping("/updateEnseignant")
    public Enseignant updateEnseignant(@RequestBody Enseignant e){
        return enseignantService.updateEnseignant(e);
    }

    @GetMapping("/getEnseignantById/{idEnseignant}")
    public Enseignant getEnseignantById(@PathVariable("idEnseignant") long idEnseignant){
        return enseignantService.getEnseignantById(idEnseignant);
    }

    @DeleteMapping("/deleteEnseignant/{idEnseignant}")
    public void deleteEnseignant(@PathVariable("idEnseignant") long idEnseignant){
        enseignantService.deleteEnseignant(idEnseignant);
    }

/**/

    @GetMapping("/getNbrJoursById/{id}")
    public Integer getNbrJoursById(@PathVariable("id") Long id){
        return enseignantService.getNbrJoursById(id);
    }


    @PutMapping("/updateSalaireAndGradeSelonDateDebutFonction")
    public List<Enseignant> updateSalaireAndGradeSelonDateDebutFonction(){
        return enseignantService.updateSalaireAndGradeSelonDateDebutFonction();
    }


    @GetMapping("/getDayById/{id}")
    public Integer getDayById(@PathVariable("id") Long id){
        return enseignantService.getDayById(id);
    }


    @PutMapping("/updateSalaireSelonChargeHoraire")
    public List<Enseignant> updateSalaireSelonChargeHoraire(){
        return enseignantService.updateSalaireSelonChargeHoraire();
    }


    @GetMapping("/findEnseignantByMatiere/{m}")
    List<Enseignant> findEnseignantByMatiere(@PathVariable("m") Matiere m){
        return enseignantService.findEnseignantByMatiere(m);
    }


    @GetMapping("/retrieveMeilleurEnseignantParMatiere/{matiere1}")
    public Enseignant retrieveMeilleurEnseignantParMatiere(@PathVariable("matiere1") Matiere matiere1){
        return enseignantService.retrieveMeilleurEnseignantParMatiere(matiere1);
    }



    /**/
    @PutMapping("/affecterEnseignantToEquipe/{idEnseignant}/{nomEquipe}")
    public Equipe affecterEnseignantToEquipe(@PathVariable("idEnseignant") long idEnseignant, @PathVariable("nomEquipe") String nomEquipe,@RequestBody Enseignant enseignant){
        return enseignantService.affecterEnseignantToEquipe(idEnseignant,nomEquipe, enseignant);
    }

    @GetMapping("/getNbrEnseignantParGrade/{grade}")
    Integer getNbrEnseignantParGrade(@PathVariable("grade") String grade){
        return enseignantService.getNbrEnseignantParGrade(grade);
    }








    /* @Autowired
    ServletContext context;
    @PostMapping("/addEns")
    @CrossOrigin(origins="http://localhost:4200")
    public Enseignant addEnseignant2(@RequestParam("image") MultipartFile file ,@RequestParam("enseignant") String enseignant) throws IOException
    {
        Enseignant enseignant1= new ObjectMapper().readValue(enseignant, Enseignant.class);


        boolean isExist= new File(context.getRealPath("/images")).exists();
        if(!isExist)
        {
            new File(context.getRealPath("/images/")).mkdir();

        }
        String filename= file.getOriginalFilename();
        String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
        File serverfile=new File(context.getRealPath("/images/" +File.separator +modifiedFileName));
        try
        {
            FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        enseignant1.setPhotoProfil(modifiedFileName);
        return enseignantService.addEnseignant(enseignant1);
    }*/
    @GetMapping("/getListStat")
    public List<Integer> getListStat(){
        return enseignantService.getListStat();
    }

}
