package ru.zaroyan.demohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.zaroyan.demohibernate.models.Person;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private static final List<String> names = Arrays.asList("Ivan", "Nikolai", "Danil", "Maksim", "Aleksey");
    private static final List<String> surnames = Arrays.asList("Ivanov", "Nikolev", "Danilov", "Maksimov", "Alekseev");
    private static final List<String> cities = Arrays.asList("Moscow", "Ufa", "Kazan", "Omsk");
    private static final Random random = new Random();

    @Transactional
    @Override
    public void run(String... args) {
        for (int i = 0; i < 20; i++) {
            Person person = generateRandomPerson();
            entityManager.persist(person);
        }
    }

    private Person generateRandomPerson() {
        String name = getRandomElement(names);
        String surname = getRandomElement(surnames);
        int age = random.nextInt(101); // случайный возраст от 0 до 100
        String phoneNumber = generateRandomPhoneNumber();
        String city = getRandomElement(cities);
        return Person.builder()
                .name(name)
                .surname(surname)
                .age(age)
                .phoneNumber(phoneNumber)
                .city(city)
                .build();
    }

    private String getRandomElement(List<String> list) {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    private String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("+7");
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
}

