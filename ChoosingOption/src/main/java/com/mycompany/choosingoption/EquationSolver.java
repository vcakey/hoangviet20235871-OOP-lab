
package com.mycompany.choosingoption;
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose kind of equation:");
        System.out.println("1. ax + b = 0");
        System.out.println("2. ax + by = 0");
        System.out.println("3. ax^2 + bx + c = 0");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveLinearSystem(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("error.");
        }

        scanner.close();
    }

    public static void solveLinearEquation(Scanner scanner) {
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("vsn.");
            } else {
                System.out.println("vn.");
            }
        } else {
            double x = -b / a;
            System.out.println(" x = " + x);
        }
    }

    public static void solveLinearSystem(Scanner scanner) {
        System.out.print(" a11: ");
        double a11 = scanner.nextDouble();
        System.out.print(" a12: ");
        double a12 = scanner.nextDouble();
        System.out.print(" b1: ");
        double b1 = scanner.nextDouble();
        System.out.print(" a21: ");
        double a21 = scanner.nextDouble();
        System.out.print(" a22: ");
        double a22 = scanner.nextDouble();
        System.out.print(" b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("vsn.");
            } else {
                System.out.println("vn.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println(" x1 = " + x1 + ", x2 = " + x2);
        }
    }

    public static void solveQuadraticEquation(Scanner scanner) {
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print(" b: ");
        double b = scanner.nextDouble();
        System.out.print(" c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("vsn.");
            } else {
                System.out.println(" x = " + (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println(" x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println(" x = " + x);
            } else {
                System.out.println("vn.");
            }
        }
    }
}
