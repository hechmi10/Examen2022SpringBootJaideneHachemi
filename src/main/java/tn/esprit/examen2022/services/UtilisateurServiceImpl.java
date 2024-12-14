package tn.esprit.examen2022.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen2022.entities.Classe;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Utilisateur;
import tn.esprit.examen2022.repositories.ClasseRepository;
import tn.esprit.examen2022.repositories.UtilisateurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {
    private final ClasseRepository classeRepository;
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur findUtilisateurById(Integer id) {
        return utilisateurRepository.findById(id).isPresent() ? utilisateurRepository.findById(id).get() : null;
    }

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur u=utilisateurRepository.findById(idUtilisateur).orElse(null);
        Classe c=classeRepository.findById(codeClasse).orElse(null);
        assert u != null;
        if(u.getClasse()!=null){
            throw new RuntimeException("Utilisateur déjà affecté au classe");
        }
        u.setClasse(c);
        utilisateurRepository.save(u);
        assert c != null;
        classeRepository.save(c);
    }

    @Override
    public Integer nbUtilisateursParNiveau(Niveau nv) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAllByNiveau(nv);
        return utilisateurRepository.countUtilisateurs(utilisateurs);
    }
}
