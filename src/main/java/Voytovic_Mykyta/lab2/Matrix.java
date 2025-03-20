package Voytovic_Mykyta.lab2;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    // Константи для обмеження розміру та значень у матриці
    private static final int MIN_LIMIT = -100;
    private static final int MAX_LIMIT = 100;
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розмірів матриці
        System.out.print("Enter number of columns (max 20): ");
        int col = scanner.nextInt();
        System.out.print("Enter number of rows (max 20): ");
        int row = scanner.nextInt();

        // Перевірка коректності введених розмірів
        if (col <= 0 || col > MAX_SIZE || row <= 0 || row > MAX_SIZE) {
            System.out.println("Error: Invalid matrix size.");
            return;
        }

        // Вибір методу заповнення матриці
        System.out.print("Enter 1 for manual input, 2 for random filling: ");
        int mode = scanner.nextInt();

        int[][] matrix = (mode == 1) ? userFillMatrix(scanner, col, row) : randomFillMatrix(col, row);

        displayMatrix(matrix);

        // Обчислення статистичних характеристик матриці
        int maxElement = findMaximum(matrix);
        int minElement = findMinimum(matrix);
        double arithmeticMean = computeArithmeticMean(matrix);
        double geometricMean = computeGeometricMean(matrix);

        // Виведення результатів
        System.out.println("Maximum element: " + maxElement);
        System.out.println("Minimum element: " + minElement);
        System.out.println("Arithmetic mean: " + arithmeticMean);
        System.out.println("Geometric mean: " + geometricMean);
    }

    // Метод для ручного введення значень у матрицю
    private static int[][] userFillMatrix(Scanner scanner, int col, int row) {
        int[][] matrix = new int[row][col];
        System.out.println("Enter matrix elements row by row:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Метод для випадкового заповнення матриці
    private static int[][] randomFillMatrix(int col, int row) {
        int[][] matrix = new int[row][col];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = random.nextInt(MAX_LIMIT - MIN_LIMIT + 1) + MIN_LIMIT;
            }
        }
        return matrix;
    }

    // Метод для виведення матриці у консоль
    private static void displayMatrix(int[][] matrix) {
        System.out.println("Generated matrix:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    // Метод для знаходження максимального значення у матриці
    private static int findMaximum(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) max = value;
            }
        }
        return max;
    }

    // Метод для знаходження мінімального значення у матриці
    private static int findMinimum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) min = value;
            }
        }
        return min;
    }

    // Метод для обчислення середнього арифметичного
    private static double computeArithmeticMean(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    // Метод для обчислення середнього геометричного
    private static double computeGeometricMean(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                product *= Math.abs(value) + 1; // Додаємо 1, щоб уникнути нулів
                count++;
            }
        }
        return Math.pow(product, 1.0 / count) - 1;
    }
}
