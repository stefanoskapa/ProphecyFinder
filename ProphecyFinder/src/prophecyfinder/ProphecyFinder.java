package prophecyfinder;

import java.util.HashSet;
import utils.Tools;
import utils.Input;

public class ProphecyFinder {

    public static void main(String[] args) {
        
        int option;
        int system = 1; //default letter value: ASCII
        HashSet <String> words;
        
        System.out.print("Enter a plain text file ");
        String fileName = Input.stringInput();
        words = Tools.getWordsFromString(Tools.getFileIntoString(fileName));
        
        do {
            System.out.println("\n[ Prophecy Finder ]\n");
            System.out.println("1) Search Associations");
            System.out.println("2) Choose System");
            System.out.println("3) Display words"); //temporary, for testing purposes
            System.out.println("4) Quit\n");
            option = Input.menuValidation(4);
            switch (option) {
                
                case 1:
                    System.out.print("Enter a word ");
                    String inputWord = Input.stringInput().toUpperCase();
                    System.out.println();
                    for (String word : words) {
                        if (Tools.convWord(word,system) == Tools.convWord(inputWord,system)) {
                            System.out.println(inputWord + " = " + word + " = " + Tools.convWord(word,system));
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n1) ASCII values");
                    System.out.println("2) Pythagorean system");                 
                    system = Input.menuValidation(2);
                    break;
                case 3:
                    for (String word : words) {
                        System.out.println(word);
                    }
                    break;
            }
        } while (option != 4);
    }
}
