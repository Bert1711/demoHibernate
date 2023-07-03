package ru.zaroyan.demohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.zaroyan.demohibernate.models.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findByCityOfLiving(String city) {
        return entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.city = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}


/**
 * Аннотация @PersistenceContext в Spring и JPA используется для инъекции (внедрения) EntityManager в класс или бин.
 * EntityManager представляет собой основной интерфейс для работы с объектами в контексте хранения JPA
 * и управления персистентностью данных.
 *
 * Когда вы помечаете поле или метод с аннотацией @PersistenceContext,
 * Spring автоматически внедряет EntityManager в это поле или вызывает метод
 * с аргументом EntityManager при создании экземпляра класса или бина.
 * Это позволяет вам использовать EntityManager для выполнения операций базы данных,
 * таких как сохранение, загрузка, обновление и удаление сущностей.
 */
