package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Tools {

    public static String getFileIntoString(String fileName) {
        String str;
        StringBuilder strb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((str = br.readLine()) != null) {
                strb.append(str).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName + " not found!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("I/O Exception!");
            System.exit(0);
        }

        return strb.toString();

    }

    public static HashSet<String> getWordsFromString(String book) {

        HashSet<String> wordsInFile = new HashSet();
        String regex = "[^a-zA-Z']+";
        String[] words;
        words = book.split(regex);
        for (String i : words) {
            wordsInFile.add(i.toUpperCase());
        }
        return wordsInFile;
    }

    public static int convWord(String word, int system) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += Tools.convLetter(word.charAt(i), system);
        }
        return sum;
    }

    public static int convLetter(char a, int system) {
        int tempCode = 0;

        switch (system) {
            case 1: //ascii values
                if (Character.isLetter(a)) {
                    tempCode = a;
                }
                break;
            case 2: //pythagorean
                if (Character.isLetter(a)) {
                    tempCode = (a - 2) % 9 + 1;
                }
                break;
        }
        return tempCode;
    }

}
