package utils;

import java.util.Scanner;

public class Input {

    public static int menuValidation(int numOpt) {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Please choose an option -> ");
            String input = scanner.nextLine();
            for (int i = 1; i <= numOpt; i++) {
                if (input.trim().equals(Integer.toString(i))) {
                    return i;
                }
            }
            System.out.println("Please enter a number from 1 to " + numOpt);
        } while (true);
    }


public static String stringInput () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> ");
        String input = scanner.nextLine();
        
        while (input.equals("")) {
            System.out.println("Wrong Input");
            System.out.print("-> ");
            input = scanner.nextLine();           
            }       
        return input;
    }
}
