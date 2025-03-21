package Voytovic_Mykyta.lab3.model;

import java.util.List;

// Клас університету
public class University extends OrganizationUnit {
    private List<Faculty> faculties;

    public University(String title, Person director, List<Faculty> faculties) {
        super(title, director);
        this.faculties = faculties;
    }

    // Отримання списку факультетів
    public List<Faculty> obtainFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return String.format("University{name='%s', Rector=%s, Faculties=%s}", title, director, faculties);
    }
}
