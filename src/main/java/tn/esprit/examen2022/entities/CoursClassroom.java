package tn.esprit.examen2022.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoursClassroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private String nom;

    private Integer nbHeures;

    private boolean archive;

    @ManyToOne
    private Classe classe;
}
