package ru.zaroyan.demohibernate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zaroyan.demohibernate.models.Person;
import ru.zaroyan.demohibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityName(city);
    }


    @GetMapping("/age")
    public List<Person> getPersonsByAgeLessThan(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/name")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}

