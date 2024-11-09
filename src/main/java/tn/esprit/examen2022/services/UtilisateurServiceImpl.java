package tn.esprit.examen2022.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen2022.entities.Utilisateur;
import tn.esprit.examen2022.repositories.UtilisateurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements IUtilisateurService {
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
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
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
}
