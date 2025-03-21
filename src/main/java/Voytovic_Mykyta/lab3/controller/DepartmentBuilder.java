package Voytovic_Mykyta.lab3.controller;

import Voytovic_Mykyta.lab3.element.Department;
import Voytovic_Mykyta.lab3.element.Person;
import Voytovic_Mykyta.lab3.element.Group;
import Voytovic_Mykyta.lab3.element.Student;

import java.util.Arrays;
import java.util.List;

// Клас для створення кафедри
public class DepartmentBuilder {
    public static Department createDepartmentWithGroups(String title) {
        Person head = new Student("Микола", "Ярий", "Олексійович", Person.Gender.MALE);
        List<Group> groups = Arrays.asList(
                GroupBuilder.createGroupWithStudents("Група 125")
        );
        return new Department(title, head, groups);
    }
}