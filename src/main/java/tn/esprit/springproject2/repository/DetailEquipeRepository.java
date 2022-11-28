package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.springproject2.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long> {
    @Query("SELECT e from DetailEquipe e where e.thematique=:th")
    List<DetailEquipe> findDetailEquipeByThematiqueLike(String th);
}
