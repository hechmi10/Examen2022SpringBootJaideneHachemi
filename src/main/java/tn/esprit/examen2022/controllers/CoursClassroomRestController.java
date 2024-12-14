package tn.esprit.examen2022.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.entities.Niveau;
import tn.esprit.examen2022.entities.Specialite;
import tn.esprit.examen2022.services.ICoursClassroomService;

import java.util.List;

@Tag(name = "Gestion des classrooms")
@RestController
@AllArgsConstructor
@RequestMapping("/cours-classroom")
public class CoursClassroomRestController {
    private ICoursClassroomService coursClassroomService;

    @GetMapping("/get-all-cours")
    public List<CoursClassroom> getAllCours(){
        return coursClassroomService.findAllCoursClassrooms();
    }

    @GetMapping("/get-cours/{cours-id}")
    public CoursClassroom getCoursById(@PathVariable("cours-id") int coursId){
        return coursClassroomService.findCoursClassroomById(coursId);
    }

    @PostMapping("/add-cours")
    public CoursClassroom addCours(@RequestBody CoursClassroom coursClassroom){
        return coursClassroomService.createCoursClassroom(coursClassroom);
    }

    @PutMapping("/modify-cours")
    public CoursClassroom modifyCours(@RequestBody CoursClassroom coursClassroom){
        return coursClassroomService.updateCoursClassroom(coursClassroom);
    }

    @DeleteMapping("/remove-cours/{cours-id}")
    public void deleteCours(@PathVariable("cours-id") int coursId){
        coursClassroomService.deleteCoursClassroom(coursId);
    }

    @PutMapping("/ajouter-cours-classroom/{code-classe}")
    public CoursClassroom ajouterCoursClassroom(@RequestBody CoursClassroom cc,@PathVariable("code-classe") Integer codeClasse){
        return coursClassroomService.ajouterCoursClassroom(cc,codeClasse);
    }

    @PutMapping("/desaffecter-cours-classroom-classe/{id-cours}")
    public void desaffecterCoursClassroomClasse(@PathVariable("id-cours") Integer idCours){
        coursClassroomService.desaffecterCoursClassroomClasse(idCours);
    }

    @GetMapping("/nb-heures-par-sp-et-niv/{specialite}/{niveau}")
    public Integer nbHeuresParSpEtNiv(@PathVariable("specialite") Specialite sp,@PathVariable("niveau") Niveau nv){
        return coursClassroomService.nbHeuresParSpecEtNiv(sp,nv);
    }
}
