package tn.esprit.examen2022.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen2022.entities.Utilisateur;
import tn.esprit.examen2022.services.IUtilisateurService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
    private IUtilisateurService utilisateurService;

    @GetMapping("/get-all-utilisateurs")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.findAllUtilisateurs();
    }

    @GetMapping("/get-utilisateur/{utilisateur-id}")
    public Utilisateur getUtilisateurById(@PathVariable("utilisateur-id") int utilisateurId) {
        return utilisateurService.findUtilisateurById(utilisateurId);
    }

    @PostMapping("/add-utilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @PutMapping("/modify-utlisateur")
    public Utilisateur modifyUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.updateUtilisateur(utilisateur);
    }

    @DeleteMapping("/remove-utilisateur/{utilisateur-id}")
    public void removeUtilisateur(@PathVariable("utilisateur-id") int utilisateurId) {
        utilisateurService.deleteUtilisateur(utilisateurId);
    }
}
