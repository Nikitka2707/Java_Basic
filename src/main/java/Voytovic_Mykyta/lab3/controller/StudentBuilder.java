package Voytovic_Mykyta.lab3.controller;

import Voytovic_Mykyta.lab3.model.Student;
import Voytovic_Mykyta.lab3.model.Person;

// Клас для створення студента
public class StudentBuilder {
    public static Student createStudent(String name, String surname, String patronymic, Person.Gender gender) {
        return new Student(name, surname, patronymic, gender);
    }
}

