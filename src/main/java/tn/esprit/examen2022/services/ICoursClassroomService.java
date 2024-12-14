package tn.esprit.examen2022.services;

import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Specialite;

import java.util.List;

public interface ICoursClassroomService {
    List<CoursClassroom> findAllCoursClassrooms();
    CoursClassroom findCoursClassroomById(Integer id);
    CoursClassroom createCoursClassroom(CoursClassroom coursClassroom);
    void deleteCoursClassroom(Integer id);
    CoursClassroom updateCoursClassroom(CoursClassroom coursClassroom);
    CoursClassroom ajouterCoursClassroom (CoursClassroom cc,  Integer codeClasse);
    void desaffecterCoursClassroomClasse(Integer idCours);
    Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
}
