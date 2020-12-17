package prophecyfinder;

import java.util.HashSet;
import java.util.List;
import utils.Tools;
import utils.Input;
import static utils.Tools.convWord;

public class ProphecyFinder {

    public static void main(String[] args) {
        String input;
        int option;
        int sys = 1; //default numerology system
        List<String> words;
        HashSet <String> matches;
        String fileName;
        if (args.length == 0) {
        System.out.print("Enter a plain text file ");
        fileName = Input.stringInput();
        } else {
        fileName = args[1];
        }

        do {
            System.out.println("\n[ Prophecy Finder ]\n");
            System.out.println("1) Find Fragments");
            System.out.println("2) Find Words");
            System.out.println("3) Find Sentences");
            System.out.println("4) Choose System");
            System.out.println("5) Display words"); //temporary
            System.out.println("6) Display Sentences"); //temporary
            System.out.println("7) Quit\n");
            option = Input.choose(7);
            switch (option) {

                case 1:
                    matches = new HashSet();
                    words = Tools.getWords(Tools.getFile(fileName));                   
                    System.out.print("Enter text ");
                    input = Input.stringInput().toUpperCase();
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
                        System.out.println(input + " = " + i + " = " + convWord(i, sys));
                    }
                    break;
                case 2:
                    matches = new HashSet();
                    words = Tools.getWords(Tools.getFile(fileName));                   
                    System.out.print("Enter text ");
                    input = Input.stringInput().toUpperCase();
                    System.out.println();
                    for (String i: words) {
                        if (convWord(input,sys) == convWord(i,sys)) {
                            matches.add(i);
                        }
                    }
                    for (String i: matches) {
                         System.out.println(input + " = " + i + " = " + convWord(i, sys));
                    }
                    break;
                case 3:
                    words = Tools.getSentences(Tools.getFile(fileName));
                    HashSet<String> sentences = new HashSet();
                    System.out.print("Enter text ");
                    input = Input.stringInput().toUpperCase();
                    System.out.println();
                    for (String i : words) {
                        if (convWord(i, sys) == convWord(input, sys)) {
                            sentences.add(i);
                        }
                    }

                    for (String i : sentences) {
                        System.out.println(input + " = " + i.replace("\n"," ") + " = " + convWord(i, sys));
                    }
                    break;
                case 4:
                    System.out.println("\n1) ASCII values");
                    System.out.println("2) Pythagorean system");
                    sys = Input.choose(2);
                    break;
                case 5:
                    words = Tools.getWords(Tools.getFile(fileName));

                    for (String word : words) {
                        System.out.println(word);
                    }
                    break;
                case 6:
                    words = Tools.getSentences(Tools.getFile(fileName));
                    for (String i : words) {
                        System.out.println(i.replace("\n", " "));
                    }
                    break;
            }
        } while (option != 7);
    }
}
