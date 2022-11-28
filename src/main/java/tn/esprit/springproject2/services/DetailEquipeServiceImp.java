package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.DetailEquipe;
import tn.esprit.springproject2.repository.DetailEquipeRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class DetailEquipeServiceImp implements DetailEquipeService{
    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe dq) {
        return detailEquipeRepository.save(dq);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe dq) {
        return detailEquipeRepository.save(dq);
    }

    @Override
    public DetailEquipe getDetailEquipeById(Long idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);
    }

    @Override
    public void deleteDetailEquipe(Long idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }

    @Override
    public List<DetailEquipe> findDetailEquipeByThematiqueLike(String th) {
        return detailEquipeRepository.findDetailEquipeByThematiqueLike(th);
    }


}
