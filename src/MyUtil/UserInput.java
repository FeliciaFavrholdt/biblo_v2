package MyUtil;

import java.util.Scanner;

public class UserInput {

    public static String getString(String s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(s + " : ");
        return scanner.nextLine();
    }
}
