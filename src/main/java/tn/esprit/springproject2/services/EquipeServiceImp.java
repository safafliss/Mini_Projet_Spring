package tn.esprit.springproject2.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject2.entities.Equipe;
import tn.esprit.springproject2.entities.Niveau;
import tn.esprit.springproject2.repository.EquipeRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class EquipeServiceImp implements EquipeService{
    EquipeRepository equipeRepository;

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
}
