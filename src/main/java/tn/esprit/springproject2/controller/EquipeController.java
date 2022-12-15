package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;
import tn.esprit.springproject2.services.EquipeService;

import java.util.List;
@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EquipeController {
    EquipeService equipeService;

    @GetMapping("/getEquipes")
    public List<Equipe> getAllEquipe(){
        return equipeService.getAllEquipe();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe updEquipe){
        return equipeService.updateEquipe(updEquipe);
    }

    @GetMapping("/getEquipeById/{id}")
    public Equipe getEquipeById(@PathVariable Long id){
        return equipeService.getEquipeById(id);
    }

    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe(@PathVariable Long id){
        equipeService.deleteEquipe(id);
    }


    @GetMapping("/findEquipeByDetailEquipeThematiqueLike/{th}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("th") String th){
        return equipeService.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @GetMapping("/findEquipeByEtudiantsIdEtudiant/{id}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(@PathVariable("id") long id){
        return equipeService.findEquipeByEtudiantsIdEtudiant(id);
    }

    @GetMapping("/findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull/{idEtudiant}")
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull (@PathVariable("idEtudiant") long idEtudiant){
        return equipeService.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @GetMapping("/findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart/{idEtudiant}/{idDepart}")
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart (@PathVariable("idEtudiant") long idEtudiant,@PathVariable("idDepart") long idDepart){
        return equipeService.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique (@PathVariable("niveau") Niveau niveau ,@PathVariable("thematique") String thematique){
        return equipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/deleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeService.deleteEquipeByNiveau(niveau);
    }
    @GetMapping("/findEquipeByEnseignantIdEnseignant/{idEnseignant}")
    List<Equipe> findEquipeByEnseignantIdEnseignant(@PathVariable("idEnseignant") long idEnseignant){
        return equipeService.findEquipeByEnseignantIdEnseignant(idEnseignant);
    }
    @GetMapping("/findEquipeNomEquipeByEnseignantIdEnseignant/{idEnseignant}")
    List<String> findEquipeNomEquipeByEnseignantIdEnseignant(@PathVariable("idEnseignant") long idEnseignant){
        return equipeService.findEquipeNomEquipeByEnseignantIdEnseignant(idEnseignant);
    }
    @GetMapping("/findListEquipe")
    List<String> findListEquipe(){
        return equipeService.findListEquipe();
    }
    @GetMapping("/findEquipeByNomEquipe/{nomEquipe}")
    Equipe findEquipeByNomEquipe(@PathVariable("nomEquipe") String nomEquipe){
        return equipeService.findEquipeByNomEquipe(nomEquipe);
    }
    @GetMapping("/findAutresEquipes/{idEnseignant}")
    List<String> findAutresEquipes(@PathVariable("idEnseignant") long idEnseignant){
        return equipeService.findAutresEquipes(idEnseignant);
    }






    @GetMapping("/findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart/{idEtudiant}/{idDepart}")
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(@PathVariable("idEtudiant") Long idEtdudiant,@PathVariable("idDepart") Long idDepart){
        return equipeService.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtdudiant,idDepart);
    }
    @GetMapping("/getNbrEtudiantparEquipe/{idEquipe}")
    public int getNbrEtudiantparEquipe(@PathVariable("idEquipe") Long idEquipe){
        return equipeService.getNbrEtudiantparEquipe(idEquipe);
    }

    @GetMapping("/getMoyenneEquipe/{idEquipe}")
    public float getMoyenneEquipe(@PathVariable("idEquipe") Long idEquipe){
        return equipeService.getMoyenneEquipe(idEquipe);
    }


    @GetMapping("/equipes")
    public ResponseEntity<List<Equipe>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "idEquipe") String sortBy)
    {
        List<Equipe> list = equipeService.getAllEquipes(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Equipe>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Equipe>> searchEquipes(@RequestParam("query") String query){
        return ResponseEntity.ok(equipeService.searchEquipes(query));
    }

    @GetMapping("/getAllAsc")
    public List<Equipe> getAllAsc(){
        return equipeService.getAllAsc();
    }

    @GetMapping("/getAllDesc")
    public List<Equipe> getAllDesc(){
        return equipeService.getAllDesc()   ;
    }

    @PostMapping("/assignEtudianttoEquipe/{idEtudiant}/{idEquipe}")
    public void assignEtudianttoEquipe(@PathVariable("idEtudiant") Long idEtudiant,@PathVariable("idEquipe") Long idEquipe){
        equipeService.assignEtudianttoEquipe(idEtudiant,idEquipe);
    }




}
