package Voytovic_Mykyta.lab3.controller;

import Voytovic_Mykyta.lab3.element.Student;
import Voytovic_Mykyta.lab3.element.Person;

// Клас для створення студента
public class StudentBuilder {
    public static Student createStudent(String name, String surname, String patronymic, Person.Gender gender) {
        return new Student(name, surname, patronymic, gender);
    }
}

