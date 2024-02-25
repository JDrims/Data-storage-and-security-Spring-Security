package com.example.Hibernate.repository;

import com.example.Hibernate.entity.Contact;
import com.example.Hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Person, Contact> {

    @Query(value = "SELECT * FROM persons WHERE lower(city_of_living) = lower(:city)", nativeQuery = true)
    List<Person> findPersonByCity(String city);

    @Query(value = "SELECT * FROM persons WHERE age < :age ORDER BY age", nativeQuery = true)
    List<Person> findPersonByAgeOrderByAgeAsc(Integer age);

    @Query(value = "SELECT * FROM persons WHERE lower(name) = lower(:name) and lower(surname) = lower(:surname)", nativeQuery = true)
    Optional<Person> findPersonByNameAndSurnameAllContainingIgnoreCase(String name, String surname);
}
