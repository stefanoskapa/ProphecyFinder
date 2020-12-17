package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Tools {

    public static String getFile(String fileName) {
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

    public static List<String> getWords(String book) {
        return Arrays.asList(book.toUpperCase().split("[^a-zA-Z']+"));
    }

    public static int convWord(String word, int sys) {
        int sum=0;
        for (int i = 0; i < word.length(); i++) {
            sum += Tools.convLetter(word.charAt(i), sys);
        }
        return sum;
    }

    private static int convLetter(char a, int sys) {
        int tempCode = 0;
        switch (sys) {
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
