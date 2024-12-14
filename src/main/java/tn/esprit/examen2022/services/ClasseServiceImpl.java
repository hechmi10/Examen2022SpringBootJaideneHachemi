package tn.esprit.examen2022.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen2022.entities.Classe;
import tn.esprit.examen2022.repositories.ClasseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseServiceImpl implements IClasseService{

    private ClasseRepository classeRepository;

    @Override
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Classe getClasseById(Integer id) {
        return classeRepository.findById(id).isPresent() ? classeRepository.findById(id).get() : null;
    }

    @Override
    public Classe ajouterClasse(Classe c) {
        return classeRepository.save(c);
    }

    @Override
    public Classe updateClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public void deleteClasse(Integer id) {
        classeRepository.deleteById(id);
    }
}
