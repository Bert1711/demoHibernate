CREATE SCHEMA schema_users;
CREATE TABLE schema_users.persons
(
    name         varchar(150),
    surname      varchar(150),
    age          int CHECK (age >= 0 AND age < 150),
    phone_number varchar(20) CHECK (phone_number ~ '^[0-9+\- ()]+$' AND CHAR_LENGTH (phone_number) >= 7
) ,
    city_of_living varchar(50),
    PRIMARY KEY (name, surname, age)
);

INSERT INTO schema_users.person(name, surname, age, phone_number, city_of_living)
VALUES ('Диего', 'Марадона', 60, '+54(10) 10-10-10', 'Буэнос-Айрес');
INSERT INTO schema_users.person(name, surname, age, phone_number, city_of_living)
VALUES ('Лев', 'Яшин', 60, '+7(001) 001-01-01', 'Москва');
INSERT INTO schema_users.person(name, surname, age, phone_number, city_of_living)
VALUES ('Криштиану', 'Роналду', 38, '+351(007) 007-07-07', 'Лиссабон');
INSERT INTO schema_users.person(name, surname, age, phone_number, city_of_living)
VALUES ('Эдуард', 'Стрельцов', 53, '+7(017) 017-17-17', 'Москва');
INSERT INTO schema_users.person(name, surname, age, phone_number, city_of_living)
VALUES ('Фёдор', 'Черенков', 55, '+7(014) 014-14-14', 'Москва');