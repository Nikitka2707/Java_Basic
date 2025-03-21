package Voytovic_Mykyta.lab4.controller;

import Voytovic_Mykyta.lab4.model.Department;
import Voytovic_Mykyta.lab4.model.Person;
import Voytovic_Mykyta.lab4.model.Group;
import Voytovic_Mykyta.lab4.model.Student;

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