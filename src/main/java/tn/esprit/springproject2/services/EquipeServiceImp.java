package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Etudiant;
import tn.esprit.springproject2.entities.Niveau;
import tn.esprit.springproject2.repository.EquipeRepository;
import tn.esprit.springproject2.repository.EtudiantRepository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class EquipeServiceImp implements EquipeService{
    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public Equipe updateEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public Equipe getEquipeById(Long idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void deleteEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(long id) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(id);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(long idEtudiant) {
        return equipeRepository.findByEtudiantsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(long idEtudiant, long idDepart) {
        return equipeRepository.findByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idEtudiant,idDepart);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public List<Equipe> findEquipeByEnseignantIdEnseignant(long idEnseignant) {
        return equipeRepository.findEquipeByEnseignantIdEnseignant(idEnseignant);
    }

    @Override
    public List<String> findEquipeNomEquipeByEnseignantIdEnseignant(long idEnseignant) {
        return equipeRepository.findEquipeNomEquipeByEnseignantIdEnseignant(idEnseignant);
    }

    @Override
    public List<String> findListEquipe() {
        return equipeRepository.findListEquipe();
    }

    @Override
    public Equipe findEquipeByNomEquipe(String nomEquipe) {
        return equipeRepository.findEquipeByNomEquipe(nomEquipe);
    }

    @Override
    public List<String> findAutresEquipes(long idEnseignant) {
        return equipeRepository.findAutresEquipes(idEnseignant);
    }






    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long idetdudiant, Long idDepart) {
        return equipeRepository.findEquipeByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(idetdudiant,idDepart);
    }



    @Override
    public int getNbrEtudiantparEquipe(Long idEquipe) {
        List<Etudiant> etudiants = this.etudiantRepository.findByEquipes_IdEquipe(idEquipe);
        int nb = etudiants.size();
        return nb;
    }
    @Override
    public float getMoyenneEquipe(Long idEquipe){
        float notes = 0;
        List<Etudiant> etudiants = this.etudiantRepository.findByEquipes_IdEquipe(idEquipe);
        int nb = etudiants.size();
        for (int i=0;i<nb;i++){
            Etudiant etudiant=etudiants.get(i);
            notes += etudiant.getNote();
        }
        float moy= notes/nb;
        return moy;
    }

    @Override
    public List<Equipe> getAllEquipes(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Equipe> pagedResult = equipeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Equipe>();
        }
    }

    @Override
    public List<Equipe> getAllAsc() {
        List<Equipe> equipes =equipeRepository.findAllAsc(Sort.by(Sort.Direction.ASC, "nomEquipe"));
        return equipes;
    }
    @Override
    public List<Equipe> getAllDesc() {
        List<Equipe> equipes =equipeRepository.findAllDesc(Sort.by(Sort.Direction.DESC, "nomEquipe"));
        return equipes;
    }



    @Override
    public List<Equipe> searchEquipes(String query) {
        List<Equipe> equipes = equipeRepository.searchEquipes(query);
        return equipes;
    }

    @Transactional
    @Override
    public void assignEtudianttoEquipe(Long idEtudiant, Long idEquipe) {
        Etudiant etudiant= this.etudiantRepository.findById(idEtudiant).orElse(null);
        Equipe equipe= this.equipeRepository.findById(idEquipe).orElse(null);
        equipe.getEtudiants().add(etudiant);
        etudiant.getEquipes().add(equipe);

        etudiantRepository.save(etudiant);
        equipeRepository.save(equipe);
    }


}
