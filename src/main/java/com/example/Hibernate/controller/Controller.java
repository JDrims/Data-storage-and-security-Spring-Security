package com.example.Hibernate.controller;

import com.example.Hibernate.entity.Person;
import com.example.Hibernate.repository.Repository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class Controller {
    private final Repository repository;

    @GetMapping("/persons/by-city")
    public List<Person> findPersonByCity(@RequestParam(value = "city", required = false) String city) {
        return repository.findPersonByCity(city);
    }

    @GetMapping("/persons/by-age")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Person> findPersonByAgeOrderByAgeAsc(@RequestParam(value = "age", required = false) Integer age) {
        return repository.findPersonByAgeOrderByAgeAsc(age);
    }

    @GetMapping("/persons/by-name&surname")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Optional<Person> findPersonByNameAndSurnameAllContainingIgnoreCase(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname) {
        return repository.findPersonByNameAndSurnameAllContainingIgnoreCase(name, surname);
    }

    @GetMapping("/persons/welcome")
    public String messageWelcome() {
        return "<h1>Welcome</h1>";
    }
}
