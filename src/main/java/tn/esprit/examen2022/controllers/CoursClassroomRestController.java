package tn.esprit.examen2022.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen2022.entities.CoursClassroom;
import tn.esprit.examen2022.services.ICoursClassroomService;

import java.util.List;

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
}
