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
    public static HashSet getWordsFromFile(String fileName) {

        HashSet<String> wordsInFile = new HashSet();
        String line;
        String regex = "[.,?!;:_\\- ]+";//TODO needs to be refined
        String[] words;

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(fileName));
            while ((line = textFile.readLine()) != null) {
                words = line.split(regex);
                for (String i : words) {
                    if (!i.equals("")) {
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
}
