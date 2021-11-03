package com.example.postgresspring1.Home;


import com.example.postgresspring1.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    HomeService homeService;


    @GetMapping(value = "/getStudents")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Student> startPage(){
        return homeService.findAll();
    }


    @PostMapping(value = "/student")
    @CrossOrigin(origins = "http://localhost:3000")
    public String saveStudent(@RequestBody Student student){
        homeService.saveStudent(student);
        return "student saved";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        System.out.println("deleted id  = "+id);
        homeService.deleteStudentById(id);
        return "student deleted";
    }

}