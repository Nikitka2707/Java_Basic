package Voytovic_Mykyta.lab4.model;

import java.util.Objects;

// Абстрактний клас базового підрозділу
public abstract class OrganizationUnit {
    protected String title;
    protected Person director;

    public OrganizationUnit(String title, Person director) {
        this.title = title;
        this.director = director;
    }

    // Безпараметровий конструктор (необхідний для Gson)
    public OrganizationUnit() {}

    public String getTitle() {
        return title;
    }

    public Person getDirector() {
        return director;
    }

    // Сетери для JSON-десеріалізації
    public void assignTitle(String title) {
        this.title = title;
    }

    public void assignDirector(Person director) {
        this.director = director;
    }

    // equals() для порівняння об'єктів
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OrganizationUnit that = (OrganizationUnit) obj;
        return Objects.equals(title, that.title) &&
                Objects.equals(director, that.director);
    }

    // hashCode() для коректної роботи в HashSet, HashMap
    @Override
    public int hashCode() {
        return Objects.hash(title, director);
    }

    @Override
    public String toString() {
        return title + " (Head: " + director + ")";
    }
}
