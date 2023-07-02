package ru.zaroyan.demohibernate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "surname", length = 150)
    private String surname;

    @Column(name = "age")
    @Check(constraints = "age >= 0 AND age < 150")
    private int age;

    @Column(name = "phone_number", length = 20)
    @Check(constraints = "phone_number ~ '^[0-9+\\- ()]+$' AND CHAR_LENGTH(phone_number) >= 7")
    private String phoneNumber;

    @ManyToOne(optional = false)
    private City city;
}

