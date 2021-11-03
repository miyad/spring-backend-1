package com.example.postgresspring1.Home;

import com.example.postgresspring1.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Student,Long> {

}
