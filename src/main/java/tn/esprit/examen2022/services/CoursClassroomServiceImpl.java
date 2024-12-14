package tn.esprit.examen2022.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen2022.entities.Classe;
import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Specialite;
import tn.esprit.examen2022.repositories.ClasseRepository;
import tn.esprit.examen2022.repositories.CoursClassroomRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CoursClassroomServiceImpl implements ICoursClassroomService {

    private final ClasseRepository classeRepository;
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

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe c=classeRepository.findById(codeClasse).orElse(null);
        assert c != null;
        if(c.getCoursClassrooms()!=null){
            throw new RuntimeException("Classroom existant");
        }
        return coursClassroomRepository.save(cc);
    }

    @Override
    public void desaffecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = coursClassroomRepository.findById(idCours).orElse(null);
        assert cc != null;
        if(cc.getClasse()==null){
            throw new RuntimeException("Aucun classe existant de cet CoursClassroom");
        }
        cc.setClasse(null);
        coursClassroomRepository.save(cc);
    }

    @Override
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv) {
        return coursClassroomRepository.getNbHeuresBySpecialiteAndNiveau(sp, nv);
    }

    @Scheduled(cron="0 * * * * *")
    public void archiverCoursClassrooms() {
        List<CoursClassroom> coursClassrooms = coursClassroomRepository.findAll();
        for(CoursClassroom cc:coursClassrooms){
            if(cc.isArchive()){
                log.info("Nom:{}\nSpecialité:{}\nNombre d'heures:{}",cc.getNom(),cc.getSpecialite(),cc.getNbHeures());
            }else{
                log.info("Pas de cours disponibles");
            }

        }

    }
}
