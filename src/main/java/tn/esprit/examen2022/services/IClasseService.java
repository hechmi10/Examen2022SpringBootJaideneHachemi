package tn.esprit.examen2022.services;

import tn.esprit.examen2022.entities.Classe;

import java.util.List;

public interface IClasseService {
    List<Classe> getAllClasses();
    Classe getClasseById(Integer id);
    Classe addClasse(Classe classe);
    Classe updateClasse(Classe classe);
    void deleteClasse(Integer id);
}
