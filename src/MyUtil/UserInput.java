package MyUtil;

import java.util.Scanner;

public class UserInput {

    public static String getString(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(s + " : ");
        return scanner.nextLine();
    }

    public static int getInt(String s) {
        while (true) {
            try {
                return Integer.parseInt(getString(s));
            } catch (NumberFormatException e) {
                System.out.println("You need to enter a number, not words");
            }
        }
    }
}
