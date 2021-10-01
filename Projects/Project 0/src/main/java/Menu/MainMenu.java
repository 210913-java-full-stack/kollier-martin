package Menu;

import java.util.Scanner;

public class MainMenu implements PrintView {

    private Scanner scn = new Scanner(System.in);

    @Override
    public void printMenu(String input) {
        System.out.println("============= MAIN MENU ===============" +
                "\nEnter selection:" +
                "\n\t1) Login" +
                "\n\t2) Create an Account" +
                "\n\tQ) Quit");
        input = scn.nextLine();

        switch (input) {
            case "1":
                // pvl.printMyView(login);
                break;
            case "2":
                // pvc.printMyView(create);
                break;
            case "q":
            case "Q":
                scn.close();
                System.out.println("Quit Acknowledged. Goodbye!");
                System.exit(0);
                break;
        }
    }
}
