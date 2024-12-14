package tn.esprit.examen2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Utilisateur;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    List<Utilisateur> findAllByNiveau(Niveau niveau);

    int countUtilisateurs(List<Utilisateur> utilisateurs);
}
