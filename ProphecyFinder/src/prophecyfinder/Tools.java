package prophecyfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Tools {

    /* Method that reads the specified file and returns a HashSet with all 
       the words in it. Hashset has been chosen, as there is no need of
       multiple word occurences 
     */
    public static HashSet<String> getWordsFromFile(String fileName) {

        HashSet<String> wordsInFile = new HashSet();
        String line;
        String regex = "[.,?!;:_&()\\-\\[\\] ]+";// works but might need improvement
        String[] words;

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(fileName));
            while ((line = textFile.readLine()) != null) {
                words = line.split(regex);
                for (String i : words) {
                    if (!i.equals("") && !i.matches(".*\\d+.*")) { //excludes numbers
                        wordsInFile.add(i.toUpperCase());
                    }
                }
            }
            textFile.close();
            return wordsInFile;
        } catch (IOException ex) {
            System.out.println("File not found!");
            System.exit(0);
        }

        return wordsInFile;
    }

    public static int wordToNumber(String word) {
        /*
        this method can later accept a second parameter, which will specify
        the numorology system (ex. Pythagorean, ASCII, custom etc.)
        */
        
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum;
    }
}
