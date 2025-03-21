package Voytovic_Mykyta.lab3.main;

import Voytovic_Mykyta.lab3.element.*;
import Voytovic_Mykyta.lab3.controller.*;

public class Run {
    public static void main(String[] args) {
        // Створення університету за допомогою спеціального будівельника
        University uni = UniversityBuilder.constructStandardUniversity();

        System.out.println("Назва університету: " + uni.getTitle());
        System.out.println("Ректор: " + formatPerson(uni.getDirector()));
        System.out.println();

        // Виведення інформації про факультети
        for (Faculty fac : uni.obtainFaculties()) {
            System.out.println("Факультет: " + fac.getTitle());
            System.out.println("Декан: " + formatPerson(fac.getDirector()));
            System.out.println();

            // Виведення інформації про кафедри
            for (Department dep : fac.obtainDepartments()) {
                System.out.println("Кафедра: " + dep.getTitle());
                System.out.println("Завідувач кафедри: " + formatPerson(dep.getDirector()));
                System.out.println();

                // Виведення інформації про групи
                for (Group grp : dep.obtainGroups()) {
                    System.out.println("Навчальна група: " + grp.getTitle());
                    System.out.println("Староста групи: " + formatPerson(grp.getDirector()));
                    System.out.println("Список студентів:");

                    // Виведення списку студентів
                    for (Student std : grp.obtainStudents()) {
                        System.out.println("- " + formatPerson(std));
                    }
                    System.out.println();
                }
            }
        }
    }

    // Форматування інформації про особу
    private static String formatPerson(Person person) {
        return person.getName() + " " + person.getPatronymic() + " " + person.getSurname() + " (" + person.getGender() + ")";
    }
}
