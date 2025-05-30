package com.mycompany.choosingoption;
import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String args[] ) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = keyboard.nextLine();

        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();

        System.out.println("How tall are you (m)?");
        double dHeight = keyboard.nextDouble();

        System.out.printf("Mrs./Ms. %s, %d years old. Your height is %.2f m.%n", strName, iAge, dHeight);

    }
}

