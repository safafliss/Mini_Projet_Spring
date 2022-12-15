package tn.esprit.springproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.springproject2.entities.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
}
