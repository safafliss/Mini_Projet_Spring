package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.springproject2.entities.DetailEquipe;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.repository.DetailEquipeRepository;
import tn.esprit.springproject2.repository.EquipeRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class DetailEquipeServiceImp implements DetailEquipeService{
    DetailEquipeRepository detailEquipeRepository;
    EquipeRepository equipeRepository;

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
    @Override
    public List<DetailEquipe> getAllDEquipes(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<DetailEquipe> pagedResult = detailEquipeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DetailEquipe>();
        }
    }


    @Override
    public DetailEquipe findDetailEquipeByEquipe(Long idEquipe) {
        return detailEquipeRepository.findDetailEquipeByEquipeIdEquipe(idEquipe);
    }

    @Override
    public List<DetailEquipe> getAllAsc() {
        List<DetailEquipe> detailEquipes =detailEquipeRepository.findAllAsc(Sort.by(Sort.Direction.ASC, "thematique"));
        return detailEquipes;
    }
    @Override
    public List<DetailEquipe> getAllDesc() {
        List<DetailEquipe> detailEquipes =detailEquipeRepository.findAllDesc(Sort.by(Sort.Direction.DESC, "thematique"));
        return detailEquipes;
    }

    @Transactional
    @Override
    public DetailEquipe addAndAssignDetailEquipeToEquipe(DetailEquipe detailEquipe, Long idEquipe) {
        Equipe equipe=this.equipeRepository.findById(idEquipe).orElse(null);
        equipe.setDetailEquipe(detailEquipe);
        return detailEquipeRepository.save(detailEquipe);
    }



}
