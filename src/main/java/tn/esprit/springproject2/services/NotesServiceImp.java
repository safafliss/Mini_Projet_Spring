package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.repository.NotesRepository;

@AllArgsConstructor
@Service
public class NotesServiceImp implements NotesService{
    NotesRepository notesRepository;
}
