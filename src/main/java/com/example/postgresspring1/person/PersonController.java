package com.example.postgresspring1.person;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/getPersons")
    public Iterable<Person> getPersons() {
        return personService.findAll();
    }
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping(value = "/newPerson")
    public Person newPerson(@RequestBody Person person) {
        String password = person.getPassword();
        String md5Hex = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
        person.setPassword(md5Hex);
        return personService.save(person);
    }

    @GetMapping("/isPersonExists/{email}")
    public boolean isPersonExists(@PathVariable String email) {
        Person person = personService.findByEmail(email);
        Long id = 0L;
        if (person != null) {
            id = person.getId();
        }
        return personService.isPersonExists(id);
    }
    @GetMapping("/isPersonValid/{email}/{password}")
    public Long isPersonValid(@PathVariable String email, @PathVariable String password){
        Person person = personService.findByEmail(email);
        Long id = 0L;
        String md5Hex = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
        if(person != null){
            id = person.getId();
            if(personService.isPersonExists(id) && person.getPassword().equals(md5Hex))
                return id;
        }

        return 0L;
    }

}

