package Voytovic_Mykyta.lab3.element;

// Абстрактний клас базового підрозділу
public abstract class OrganizationUnit {
    protected String title;
    protected Person director;

    public OrganizationUnit(String title, Person director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public Person getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return title + " (Head: " + director + ")";
    }
}
