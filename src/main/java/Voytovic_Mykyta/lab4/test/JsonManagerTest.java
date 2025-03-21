package Voytovic_Mykyta.lab4.test;

import Voytovic_Mykyta.lab4.json.JsonManager;
import Voytovic_Mykyta.lab4.model.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonManagerTest {
    @Test
    void checkJsonConversion() {
        // Створення керівника університету
        Person director = new Student("Michael", "Anderson", "", Person.Gender.MALE);

        // Створення початкового університету
        University oldUniversity = new University("Global Tech University", director, Arrays.asList(
                new Faculty("Computer Science", new Student("Dr. Emily", "White", "", Person.Gender.FEMALE), Arrays.asList(
                        new Department("Artificial Intelligence", new Student("Dr. Sophia", "Taylor", "", Person.Gender.FEMALE), Arrays.asList(
                                new Group("AI-301", new Student("James", "Smith", "", Person.Gender.MALE), Arrays.asList(
                                        new Student("James", "Smith", "", Person.Gender.MALE),
                                        new Student("Olivia", "Johnson", "", Person.Gender.FEMALE)
                                )),
                                new Group("AI-302", new Student("Lucas", "Brown", "", Person.Gender.MALE), Arrays.asList(
                                        new Student("Lucas", "Brown", "", Person.Gender.MALE),
                                        new Student("Emma", "Williams", "", Person.Gender.FEMALE)
                                ))
                        )),
                        new Department("Cybersecurity", new Student("Dr. Robert", "Davis", "", Person.Gender.MALE), Arrays.asList(
                                new Group("CS-401", new Student("Charlotte", "Miller", "", Person.Gender.FEMALE), Arrays.asList(
                                        new Student("Charlotte", "Miller", "", Person.Gender.FEMALE),
                                        new Student("Daniel", "Moore", "", Person.Gender.MALE)
                                )),
                                new Group("CS-402", new Student("Henry", "Taylor", "", Person.Gender.MALE), Arrays.asList(
                                        new Student("Henry", "Taylor", "", Person.Gender.MALE),
                                        new Student("Sophia", "Anderson", "", Person.Gender.FEMALE)
                                ))
                        ))
                ))
        ));

        // Збереження у JSON-файл
        String jsonFilePath = "university.json";
        JsonManager.writeToJson(oldUniversity, jsonFilePath);

        // Зчитування з JSON-файлу
        University newUniversity = JsonManager.readFromJson(jsonFilePath, University.class);

        // Перевірка чи рівні об'єкти oldUniversity і newUniversity
        System.out.println("Are universities equal? " + oldUniversity.equals(newUniversity));

        // Перевірка відповідності початкового та відновленого університетів
        assertEquals(oldUniversity, newUniversity, "Помилка: збереження або відновлення JSON виконано некоректно");
    }
}