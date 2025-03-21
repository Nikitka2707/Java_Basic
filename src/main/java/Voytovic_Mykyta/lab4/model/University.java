package Voytovic_Mykyta.lab4.model;

import java.util.List;
import java.util.Objects;

// Клас університету
public class University extends OrganizationUnit {
    private List<Faculty> faculties;

    public University(String title, Person director, List<Faculty> faculties) {
        super(title, director);
        this.faculties = faculties;
    }

    // Порожній конструктор (необхідний для Gson)
    public University() {}

    // Геттери та сеттери
    public List<Faculty> obtainFaculties() {
        return faculties;
    }

    public void assignFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    // equals() для коректного порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University that = (University) obj;
        return Objects.equals(title, that.title) &&
                Objects.equals(director, that.director) &&
                Objects.equals(faculties, that.faculties);
    }

    // hashCode() для унікальної ідентифікації об'єкта
    @Override
    public int hashCode() {
        return Objects.hash(title, director, faculties);
    }


    @Override
    public String toString() {
        return String.format("University{name='%s', Rector=%s, Faculties=%s}", title, director, faculties);
    }
}
