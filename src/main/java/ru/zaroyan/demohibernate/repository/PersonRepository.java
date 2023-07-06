package ru.zaroyan.demohibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zaroyan.demohibernate.models.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityName(String cityName);

    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<List<Person>> findByNameAndSurname(String name, String surname);
}

