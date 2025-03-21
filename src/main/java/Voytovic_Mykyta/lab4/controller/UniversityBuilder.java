package Voytovic_Mykyta.lab4.controller;

import Voytovic_Mykyta.lab4.model.Student;
import Voytovic_Mykyta.lab4.model.Person;
import Voytovic_Mykyta.lab4.model.Faculty;
import Voytovic_Mykyta.lab4.model.University;


import java.util.List;
import java.util.Arrays;

// Будівельник університету
public class UniversityBuilder {
    public static University constructStandardUniversity() {
        Person director = new Student("Олена", "Іванова", "Василівна", Person.Gender.FEMALE);
        List<Faculty> faculties = Arrays.asList(
                FacultyBuilder.createFacultyWithDepartments("Факультет інформаційних технологій")
        );
        return new University("Національний технічний університет", director, faculties);
    }
}
