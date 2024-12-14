package tn.esprit.examen2022.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Specialite;

@Repository
public interface CoursClassroomRepository extends JpaRepository<CoursClassroom, Integer> {

    @Query("Select cc.nbHeures from CoursClassroom cc join fetch cc.classe c where cc.specialite=:sp and c.niveau=:nv")
    public Integer getNbHeuresBySpecialiteAndNiveau(@Param("sp") Specialite sp,@Param("nv") Niveau nv);
}
