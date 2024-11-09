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
public class Classe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeClasse;

    private String titre;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "classe")
    private List<CoursClassroom> coursClassrooms;
}
