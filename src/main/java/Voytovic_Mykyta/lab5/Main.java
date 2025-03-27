package Voytovic_Mykyta.lab5;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentDAO studentDatabase = new StudentDAO(); // Ініціалізація об'єкта для роботи з базою студентів
        Scanner userInput = new Scanner(System.in);
        String userResponse;

        do {
            // Запит місяця народження у користувача
            System.out.println("Введіть номер місяця (наприклад, 01  для cічня): ");
            String birthMonth = userInput.nextLine();

            // Виведення результатів пошуку
            System.out.println("\n Студенти, які народилися в місяці " + birthMonth + ":");
            List<Student> studentList = studentDatabase.fetchStudentsByBirthMonth(birthMonth);

            if (studentList.isEmpty()) {
                System.out.println("❌ У цьому місяці немає студентів.");
            } else {
                studentList.forEach(System.out::println);
            }

            // Перевірка, чи хоче користувач продовжити
            System.out.print("\n Перевірити інший місяць? (так/ні): ");
            userResponse = userInput.nextLine().trim().toLowerCase();

        } while (userResponse.equals("так"));

        System.out.println("\uD83D\uDEAA Програма завершена.");
        userInput.close(); // Закриття Scanner для вивільнення ресурсів
    }
}
