package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;
import tn.esprit.springproject2.services.EquipeService;

import java.util.List;
@AllArgsConstructor
@RestController
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
}
