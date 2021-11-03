package com.example.postgresspring1.Home;

import com.example.postgresspring1.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    HomeRepository homeRepository;

    public Student findStudentById(Long id){
        return homeRepository.getById(id);
    }

    public boolean isStudentExists(Long id){
        return homeRepository.existsById(id);
    }

    public List<Student> findAll(){
        return homeRepository.findAll();
    }
    public Student saveStudent(Student student){
        return homeRepository.save(student);
    }

    public void deleteStudentById(Long id){
        homeRepository.deleteById(id);
    }

}
