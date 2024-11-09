package tn.esprit.examen2022.services;

import tn.esprit.examen2022.entities.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    List<Utilisateur> findAllUtilisateurs();
    Utilisateur findUtilisateurById(Integer id);
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Integer id);
    Utilisateur updateUtilisateur(Utilisateur utilisateur);
}
