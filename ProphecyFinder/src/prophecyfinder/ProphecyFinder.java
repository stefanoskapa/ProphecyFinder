package prophecyfinder;

import java.util.Iterator;

public class ProphecyFinder {

    public static void main(String[] args) {
        int numSystem = 1;
        int option;
        do {
            System.out.println("[ Prophecy Finder ]\n");
            System.out.println("1) Choose file");
            System.out.println("2) Search Associations");
            System.out.println("3) Choose System");
            System.out.println("4) Display words"); //temporary, for testing purposes
            System.out.println("5) Quit\n");
            option = Input.menuValidation(5);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    Iterator<String> itr = Tools.getWordsFromFile("test.txt").iterator();
                    while (itr.hasNext()) {
                        String temp = itr.next();
                        System.out.println(temp + " = " + Tools.wordToNumber(itr.next()));
                    }
                    break;
            }
        } while (option != 5);
    }
}
