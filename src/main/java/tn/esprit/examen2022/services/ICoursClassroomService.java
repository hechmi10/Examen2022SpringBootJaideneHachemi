package tn.esprit.examen2022.services;

import tn.esprit.examen2022.entities.CoursClassroom;

import java.util.List;

public interface ICoursClassroomService {
    List<CoursClassroom> findAllCoursClassrooms();
    CoursClassroom findCoursClassroomById(Integer id);
    CoursClassroom createCoursClassroom(CoursClassroom coursClassroom);
    void deleteCoursClassroom(Integer id);
    CoursClassroom updateCoursClassroom(CoursClassroom coursClassroom);
}
