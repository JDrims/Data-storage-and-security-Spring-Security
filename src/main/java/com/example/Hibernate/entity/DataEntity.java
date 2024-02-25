package com.example.Hibernate.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataEntity implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Person dmitriy = Person.builder().contact(Contact.builder()
                        .name("Dmitriy")
                        .surname("Dmitriy")
                        .age(24)
                        .build())
                .phoneNumber("79998886655")
                .cityOfLiving("Moscow")
                .build();
        Person andrei = Person.builder().contact(Contact.builder()
                        .name("Andrei")
                        .surname("Andrei")
                        .age(35)
                        .build())
                .phoneNumber("78887775544")
                .cityOfLiving("SPb")
                .build();
        Person maria = Person.builder().contact(Contact.builder()
                        .name("Maria")
                        .surname("Maria")
                        .age(29)
                        .build())
                .phoneNumber("71111114433")
                .cityOfLiving("Omsk")
                .build();
//        entityManager.persist(dmitriy);
//        entityManager.persist(andrei);
//        entityManager.persist(maria);
    }
}