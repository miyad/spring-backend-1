package com.example.postgresspring1.person;


import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);
}
