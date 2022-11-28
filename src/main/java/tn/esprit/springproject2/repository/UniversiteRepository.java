package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject2.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite , Long> {
}
