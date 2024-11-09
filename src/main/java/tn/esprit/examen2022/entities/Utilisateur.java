package tn.esprit.examen2022.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idUtilisateur;

    private String prenom;

    private String nom;

    private String password;

    @ManyToOne
    private Classe classe;
}
