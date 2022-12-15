package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject2.entities.ResponseMessage;

public interface ResponseMessageRepository extends JpaRepository<ResponseMessage, Long> {
}
