package com.example.postgresspring1.person;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }


    public boolean isPersonExists(@PathVariable Long id) {
        return personRepository.existsById(id);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }
}

