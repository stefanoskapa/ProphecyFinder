package prophecyfinder;

public class ProphecyFinder {

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n[ Prophecy Finder ]\n");
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
                    System.out.print("Enter a word ");
                    String inputWord = Input.stringInput().toUpperCase();
                    System.out.println();
                    for (String words : Tools.getWordsFromFile("test.txt")) {
                        if (Tools.wordToNumber(words) == Tools.wordToNumber(inputWord)) {
                            System.out.println(inputWord + " = " + words + " = " + Tools.wordToNumber(words));
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    for (String words : Tools.getWordsFromFile("test.txt")) {
                        System.out.println(words);
                    }
                    break;
            }
        } while (option != 5);
    }
}
