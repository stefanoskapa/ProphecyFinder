package prophecyfinder;

import java.util.HashSet;
import java.util.List;
import utils.Tools;
import utils.Input;
import static utils.Tools.convWord;

public class ProphecyFinder {

    public static void main(String[] args) {

        int option;
        int sys = 1; //default numerology system
        List<String> words;

        System.out.print("Enter a plain text file ");
        String fileName = Input.stringInput();
        System.out.println("loading file...");
        words = Tools.getWords(Tools.getFile(fileName));

        do {
            System.out.println("\n[ Prophecy Finder ]\n");
            System.out.println("1) Search Associations");
            System.out.println("2) Choose System");
            System.out.println("3) Display words"); //temporary
            System.out.println("4) Quit\n");
            option = Input.menuValidation(4);
            switch (option) {

                case 1:
                    HashSet<String> matches = new HashSet();
                    System.out.print("Enter text ");
                    String input = Input.stringInput().toUpperCase();
                    System.out.println();
                    String phrase;

                    for (int i = 0; i < words.size(); i++) {
                        phrase = words.get(i) + " ";
                        int incr = 1;
                        while (convWord(phrase, sys) < convWord(input, sys)
                                && (i + incr < words.size())) {
                            phrase += words.get(i + incr) + " ";
                            incr++;
                        }
                        if (convWord(phrase, sys) == convWord(input, sys)) {
                            matches.add(phrase);
                        }

                    }

                    for (String i : matches) {
                        System.out.println(input + " = " + i + " = " + Tools.convWord(i, sys));
                    }
                    break;
                case 2:
                    System.out.println("\n1) ASCII values");
                    System.out.println("2) Pythagorean system");
                    sys = Input.menuValidation(2);
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
