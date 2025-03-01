
package com.mycompany.choosingoption;
import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("first number: ");
        double num1 = Double.parseDouble(scanner.nextLine());

        System.out.print("second number: ");
        double num2 = Double.parseDouble(scanner.nextLine());

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("T: " + quotient);
        } else {
            System.out.println(" :/ 0.");
        }

        System.out.println("sum: " + sum);
        System.out.println("sub: " + difference);
        System.out.println("digit: " + product);

        scanner.close();
    }
}
