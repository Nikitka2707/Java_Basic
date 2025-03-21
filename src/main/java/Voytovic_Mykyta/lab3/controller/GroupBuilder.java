package Voytovic_Mykyta.lab3.controller;

import Voytovic_Mykyta.lab3.model.Student;
import Voytovic_Mykyta.lab3.model.Person;
import Voytovic_Mykyta.lab3.model.Group;

import java.util.Arrays;
import java.util.List;

// Клас для створення групи
public class GroupBuilder {
    public static Group createGroupWithStudents(String title) {
        Person classMonitor = new Student("Ірина", "Москаленко", "Петрівна", Person.Gender.FEMALE);
        List<Student> students = Arrays.asList(
                StudentBuilder.createStudent("Василь", "Копєйко", "Ростиславович", Person.Gender.MALE),
                StudentBuilder.createStudent("Марія", "Мезенцева", "Іллівна", Person.Gender.FEMALE),
                StudentBuilder.createStudent("Ілона", "Вінницька", "Микитівна", Person.Gender.FEMALE),
                StudentBuilder.createStudent("Микита", "Шевченко", "Валерійович", Person.Gender.MALE)
        );
        return new Group(title, classMonitor, students);
    }
}
