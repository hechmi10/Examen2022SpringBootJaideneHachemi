package tn.esprit.examen2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen2022.entities.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}
