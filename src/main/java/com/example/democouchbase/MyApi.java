package com.example.democouchbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class MyApi {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/persons")
    public List<Person> getPersons() {
        /*return Arrays.asList(
                new Person("1","Ibou", "KANE")
        );
        */
        List<Person> persons = new ArrayList<>();
        this.personRepository.findAll().forEach(p -> persons.add(p));

        return persons;
    }


    @GetMapping(path = "/persons/{lastName}")
    public Person findPerson(@PathVariable String lastName) {

        return this.personRepository.findByLastName(lastName).orElse(null);
    }

    @PostMapping(path = "/persons")
    public Person createPerson(@RequestBody Person person) {

        Person p = Person.builder()
                            .id(UUID.randomUUID().toString())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build();

        return this.personRepository.save(p);
    }
}
