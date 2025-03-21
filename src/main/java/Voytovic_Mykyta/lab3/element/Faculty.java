package Voytovic_Mykyta.lab3.element;

import java.util.List;
import java.util.stream.Collectors;

// Клас факультету
public class Faculty extends OrganizationUnit {
    private List<Department> departments;

    public Faculty(String title, Person director, List<Department> departments) {
        super(title, director);
        this.departments = departments;
    }

    // Отримання списку кафедр
    public List<Department> obtainDepartments() { return departments; }

    @Override
    public String toString() {
        String departmentList = departments.isEmpty() ? "No departments" : departments.stream()
                .map(Department::toString)
                .collect(Collectors.joining(",\n  "));
        return String.format("Faculty{name='%s', Head=%s, Departments=[\n  %s\n]}", title, director, departmentList);
    }
}
