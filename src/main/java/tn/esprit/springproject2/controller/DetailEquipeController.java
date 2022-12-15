package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject2.entities.DetailEquipe;
import tn.esprit.springproject2.services.DetailEquipeService;

import java.util.List;
@AllArgsConstructor
@RestController
public class DetailEquipeController {
    DetailEquipeService detailEquipeService;

    @GetMapping("/getDetailsEquipe")
    public List<DetailEquipe> getAllDetailEquipe(){
        return detailEquipeService.getAllDetailEquipe();
    }

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.addDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe updDetailEquipe){
        return detailEquipeService.updateDetailEquipe(updDetailEquipe);
    }

    @GetMapping("/getDetailEquipeById/{id}")
    public DetailEquipe getDetailEquipeById(@PathVariable Long id){
        return detailEquipeService.getDetailEquipeById(id);
    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    public void deleteDetailEquipe(@PathVariable Long id){
        detailEquipeService.deleteDetailEquipe(id);
    }

    @GetMapping("/findDetailEquipeByThematiqueLike/{th}")
    public List<DetailEquipe> findDetailEquipeByThematiqueLike(@PathVariable("th") String th) {
        return detailEquipeService.findDetailEquipeByThematiqueLike(th);
    }
    @GetMapping("/findByIdEquipe/{idEquipe}")
    public DetailEquipe findByIdEquipe(@PathVariable("idEquipe") Long idEquipe){
        return detailEquipeService.findDetailEquipeByEquipe(idEquipe);
    }

    @GetMapping("/getAllAscDeq")
    public List<DetailEquipe> getAllAsc(){
        return detailEquipeService.getAllAsc();
    }

    @GetMapping("/getAllDescDeq")
    public List<DetailEquipe> getAllDesc(){
        return detailEquipeService.getAllDesc()   ;
    }

    @PostMapping("/addAndAssignDetailEquipeToEquipe/{idEquipe}")
    @ResponseBody
    public DetailEquipe addAndAssignDetailEquipeToEquipe(@RequestBody DetailEquipe e, @PathVariable("idEquipe") Long idEquipe){
        DetailEquipe detailEquipe =this.detailEquipeService.addAndAssignDetailEquipeToEquipe(e,idEquipe);
        return detailEquipe;
    }
}
