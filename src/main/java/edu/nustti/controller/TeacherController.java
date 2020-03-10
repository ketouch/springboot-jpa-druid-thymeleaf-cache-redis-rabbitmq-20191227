package edu.nustti.controller;

import edu.nustti.service.TeacherService;
import edu.nustti.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LenmonCCC
 * @description
 * @create 2019/12/27  19:33
 */
@RestController
public class TeacherController {
    @Autowired
    TeacherService service;

    @GetMapping("/teacher/{id}")
    public Teacher getTeacher(@PathVariable Integer id) {
        return service.findTeacher(id);
    }

    @GetMapping("/teachers")
    public List<Teacher> getTeachers(Model model) {
       return service.findTeachers();
//        model.addAttribute("teachers",teachers);
//        return "list";
    }

    @RequestMapping("/teacher/update")
    public void updateTeacher(){
        Teacher teacher = service.findTeacher(1);
        teacher.setName("张大仙");
        service.updateTeacher(teacher);
    }

    @RequestMapping("/teacher/delete")
    public void deleteTeacher(){
        Teacher teacher = service.findTeacher(4);
        service.deleteTeacher(teacher);
    }

}
