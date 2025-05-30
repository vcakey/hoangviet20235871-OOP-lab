
package com.mycompany.choosingoption;
import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInCommonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] daysInLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = -1;
        int year = -1;

        while (true) {
            System.out.print("month (full name, abbreviation, or number): ");
            String inputMonth = scanner.next();

            if (inputMonth.matches("\\d+")) {
                month = Integer.parseInt(inputMonth);
            } else {
                inputMonth = inputMonth.toLowerCase();
                for (int i = 0; i < 12; i++) {
                    if (monthNames[i].toLowerCase().startsWith(inputMonth)) {
                        month = i + 1;
                        break;
                    }
                }
            }

            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }

        while (true) {
            System.out.print("year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Invalid year. Please enter a valid non-negative number.");
        }

        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int days = isLeapYear ? daysInLeapYear[month - 1] : daysInCommonYear[month - 1];

        System.out.println("Year " + year + ", Month " + monthNames[month - 1] + " has " + days + " days.");

        scanner.close();
    }
}
