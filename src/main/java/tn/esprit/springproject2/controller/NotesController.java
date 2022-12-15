package tn.esprit.springproject2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.springproject2.entities.Notes;
import tn.esprit.springproject2.services.NotesService;

@AllArgsConstructor
@RestController
public class NotesController {
    NotesService notesService;
}
