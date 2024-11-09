package tn.esprit.examen2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examen2022.entities.CoursClassroom;

@Repository
public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {
}
