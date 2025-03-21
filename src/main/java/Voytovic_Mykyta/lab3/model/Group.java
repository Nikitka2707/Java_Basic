package Voytovic_Mykyta.lab3.model;

import java.util.List;

// Клас групи
public class Group extends OrganizationUnit {
    private List<Student> students;

    public Group(String title, Person director, List<Student> students) {
        super(title, director);
        this.students = students;
    }

    // Отримання списку студентів у групі
    public List<Student> obtainStudents() {
        return students;
    }

    @Override
    public String toString() {
        return String.format("Group{name='%s', Head=%s, Students=%s}", title, director, students);
    }
}
