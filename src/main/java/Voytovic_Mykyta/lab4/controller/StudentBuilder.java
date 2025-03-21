package Voytovic_Mykyta.lab4.controller;

import Voytovic_Mykyta.lab4.model.Student;
import Voytovic_Mykyta.lab4.model.Person;

// Клас для створення студента
public class StudentBuilder {
    public static Student createStudent(String name, String surname, String patronymic, Person.Gender gender) {
        return new Student(name, surname, patronymic, gender);
    }
}

