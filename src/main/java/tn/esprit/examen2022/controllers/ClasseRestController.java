package tn.esprit.examen2022.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen2022.entities.Classe;
import tn.esprit.examen2022.services.IClasseService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/classe")
public class ClasseRestController {

    private IClasseService classeService;;

    @GetMapping("/get-all-classes")
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @GetMapping("/get-classe/{classe-id}")
    public Classe getClasseById(@PathVariable("classe-id") Integer classeId) {
        return classeService.getClasseById(classeId);
    }

    @PostMapping("/ajouter-classe")
    public Classe ajouterClasse(@RequestBody Classe c) {
        return classeService.ajouterClasse(c);
    }

    @PutMapping("/modify-classe")
    public Classe modifyClasse(@RequestBody Classe classe) {
        return classeService.updateClasse(classe);
    }

    @DeleteMapping("/remove-classe/{classe_id}")
    public void removeClasse(@PathVariable("classe_id") Integer classeId) {
        classeService.deleteClasse(classeId);
    }
}
