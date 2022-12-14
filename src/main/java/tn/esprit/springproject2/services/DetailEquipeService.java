package tn.esprit.springproject2.services;

import tn.esprit.springproject2.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeService {
    List<DetailEquipe> getAllDetailEquipe();
    DetailEquipe addDetailEquipe( DetailEquipe dq);
    DetailEquipe updateDetailEquipe( DetailEquipe dq);
    DetailEquipe getDetailEquipeById (Long idDetailEquipe);
    void deleteDetailEquipe( Long idDetailEquipe);
    List<DetailEquipe> findDetailEquipeByThematiqueLike(String th);
    public List<DetailEquipe> getAllDEquipes(Integer pageNo, Integer pageSize, String sortBy);

    DetailEquipe findDetailEquipeByEquipe(Long idEquipe);

    public List<DetailEquipe>getAllAsc();
    public List<DetailEquipe>getAllDesc();
    DetailEquipe addAndAssignDetailEquipeToEquipe(DetailEquipe detailEquipe, Long idEquipe);

}
