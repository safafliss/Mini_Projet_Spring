package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.entities.Notes;

import java.util.List;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}
