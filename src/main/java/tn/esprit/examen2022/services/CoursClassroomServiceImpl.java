package tn.esprit.examen2022.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.repositories.CoursClassroomRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursClassroomServiceImpl implements ICoursClassroomService {

    private CoursClassroomRepository coursClassroomRepository;

    @Override
    public List<CoursClassroom> findAllCoursClassrooms() {
        return coursClassroomRepository.findAll();
    }

    @Override
    public CoursClassroom findCoursClassroomById(Integer id) {
        return coursClassroomRepository.findById(id).isPresent() ? coursClassroomRepository.findById(id).get() : null;
    }

    @Override
    public CoursClassroom createCoursClassroom(CoursClassroom coursClassroom) {
        return coursClassroomRepository.save(coursClassroom);
    }

    @Override
    public void deleteCoursClassroom(Integer id) {
        coursClassroomRepository.deleteById(id);
    }

    @Override
    public CoursClassroom updateCoursClassroom(CoursClassroom coursClassroom) {
        return coursClassroomRepository.save(coursClassroom);
    }
}
