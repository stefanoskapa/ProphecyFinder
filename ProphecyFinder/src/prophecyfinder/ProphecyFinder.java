package prophecyfinder;

public class ProphecyFinder {

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("[ Prophecy Finder ]\n");
            System.out.println("1) Choose file");
            System.out.println("2) Search Associations");
            System.out.println("3) Quit\n");
            option = Input.menuValidation(3);
            switch (option) {
                case 1:
                    System.out.print("Enter file path and file name ");
                    Tools.openFile(Input.stringInput());
                    break;
                case 2:
                    break;
            }
        } while (option != 3);
    }
}
