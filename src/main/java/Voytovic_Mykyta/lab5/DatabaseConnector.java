package Voytovic_Mykyta.lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/university";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "Seinchano11"; // Вкажіть свій пароль

    /**
     * Підключається до бази даних MySQL і повертає об'єкт Connection.
     *
     * @return Об'єкт Connection або null у разі помилки.
     */
    static Connection establishConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Реєстрація драйвера
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
                System.out.println("✅ Підключення успішне!");
                return connection;
            } catch (ClassNotFoundException e) {
                System.out.println("❌ Драйвер MySQL не знайдено!");
            } catch (SQLException e) {
                System.out.println("❌ Помилка підключення: " + e.getMessage());
            }
            return null;
    }
}


