package com.example.postgresspring1.Home;
import com.example.postgresspring1.student.Student;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    HomeService homeService;


    @GetMapping("/")
    public String index() {
        System.out.println("hit home page");
        return "index";
    }
    @GetMapping(value = "/getStudents")
    public List<Student> startPage(){
        return homeService.findAll();
    }

    @GetMapping(value = "/getStudent/{id}")
    public Student getStudent(@PathVariable Long id){
        return homeService.findStudentById(id);
    }

    @GetMapping(value = "/isStudentExists/{id}")
    public boolean isStudentExists(@PathVariable Long id){
        return homeService.isStudentExists(id);
    }

    @PostMapping(value = "/student")
    public String saveStudent(@RequestBody Student student){
        homeService.saveStudent(student);
        return "student saved";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        homeService.deleteStudentById(id);
        return "student deleted";
    }

}
