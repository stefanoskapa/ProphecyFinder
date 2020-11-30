
package prophecyfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class Tools {
    
    /* Method that reads the file. Return type has been set temporarily to boolean
    until we decide a data Type... 
    */
    public static boolean openFile(String fileName) {
              
        BufferedReader textFile;
        
        try {
            textFile = new BufferedReader(new FileReader(fileName));
            System.out.println("File has been found!");
            textFile.close();
        } catch (IOException ex) {
            System.out.println("File not found!");
            System.exit(0);
        }
    
        return true;
}
}