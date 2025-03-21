package Voytovic_Mykyta.lab3.controller;

import Voytovic_Mykyta.lab3.model.Person;
import Voytovic_Mykyta.lab3.model.Faculty;
import Voytovic_Mykyta.lab3.model.Department;
import Voytovic_Mykyta.lab3.model.Student;

import java.util.Arrays;
import java.util.List;

// Клас для створення факультету
public class FacultyBuilder {
    public static Faculty createFacultyWithDepartments(String title) {
        Person dean = new Student("Олег", "Сич", "Володимирович", Person.Gender.MALE);
        List<Department> departments = Arrays.asList(
                DepartmentBuilder.createDepartmentWithGroups("Кафедра безпеки інформації")
        );
        return new Faculty(title, dean, departments);
    }
}
