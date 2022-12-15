package tn.esprit.springproject2.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import tn.esprit.springproject2.entities.Enseignant;
import tn.esprit.springproject2.entities.FileInfo;
import tn.esprit.springproject2.entities.ResponseMessage;
import tn.esprit.springproject2.services.EnseignantService;
import tn.esprit.springproject2.services.FilesStorageService;


//@Controller
@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FilesController {

    FilesStorageService storageService;
    EnseignantService enseignantService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<Enseignant> enseignantList = enseignantService.getAllEnseignants();
        //List<Enseignant> listEnseignant = (Enseignant o1, Enseignant o2) ->Long.toString(o1.getIdEnseignant()).compareTo(Long.toString(o2.getIdEnseignant()));
        Collections.sort(enseignantList, new SortById());
        //System.out.println(enseignantList.get(0).getIdEnseignant());
        Enseignant dernier = enseignantList.get(enseignantList.size()-1);
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            enseignantService.affecterPhotoToEnseignant(dernier.getIdEnseignant(),url );
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());




        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
class SortById implements Comparator<Enseignant> {
    public int compare(Enseignant o1, Enseignant o2) {
        long person_id1=o1.getIdEnseignant();
        long person_id2=o2.getIdEnseignant();
        if(person_id1 > person_id2){
            return 1;
        }
        else if(person_id1 < person_id2){
            return -1;
        }
        else return 0;
    }
}
