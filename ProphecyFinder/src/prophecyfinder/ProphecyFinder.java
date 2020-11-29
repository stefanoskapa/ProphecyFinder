package prophecyfinder;

public class ProphecyFinder {

    public static void main(String[] args) {
        System.out.println("[ Prophecy Finder ]\n");
        System.out.println("1) Choose file");
        System.out.println("2) Search Associations");
        System.out.println("3) Quit\n");
        int option = Input.menuValidation(3);
        switch (option) {
            case 1:
                System.out.print("Enter file path and file name ");
                Tools.openFile(Input.stringInput());
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }

    }
}
