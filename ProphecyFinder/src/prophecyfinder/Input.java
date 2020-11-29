package prophecyfinder;

import java.util.Scanner;

public class Input {

    /* This method is used for menus, in order to deal with erroneous input
           Accepts one parameter, which specifies the number of options
     */
    public static int menuValidation(int numberOfOptions) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose an option -> ");
        String input = scanner.nextLine();
        boolean validOption = false;
        for (int i = 1; i <= numberOfOptions; i++) {
            if (input.trim().equals(Integer.toString(i))) {
                validOption = true;
            }
        }
        while (!validOption) {
            System.out.println("Wrong Input. Please enter a number from 1 to " + numberOfOptions);
            System.out.print("Please choose an option -> ");
            input = scanner.nextLine();
            for (int i = 1; i <= numberOfOptions; i++) {
                if (input.trim().equals(Integer.toString(i))) {
                    validOption = true;
                }
            }
        }
        return Integer.parseInt(input);
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
