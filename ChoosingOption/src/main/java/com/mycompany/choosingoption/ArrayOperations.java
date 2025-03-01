
package com.mycompany.choosingoption;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("the array: ");
        int n = scanner.nextInt();
        int[] myArray = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            myArray[i] = scanner.nextInt();
        }

        Arrays.sort(myArray);

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / n;

        System.out.println("Sorted array: " + Arrays.toString(myArray));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        scanner.close();
    }
}
