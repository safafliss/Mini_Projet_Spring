package tn.esprit.springproject2.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.esprit.springproject2.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long>, PagingAndSortingRepository<DetailEquipe, Long> {
    @Query("SELECT e from DetailEquipe e where e.thematique=:th")
    List<DetailEquipe> findDetailEquipeByThematiqueLike(String th);

    DetailEquipe findDetailEquipeByIdDetailEquipe(Long idDetailEquipe);
    DetailEquipe findDetailEquipeByEquipeIdEquipe(Long idEquipe);

    @Query(value = "SELECT deq FROM DetailEquipe deq")
    List<DetailEquipe> findAllAsc(Sort sort);

    @Query(value = "SELECT deq FROM DetailEquipe deq")
    List<DetailEquipe> findAllDesc(Sort sort);
}
