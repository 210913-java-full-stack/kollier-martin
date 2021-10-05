package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu extends PrintView {

    public MainMenu (Scanner scn)
    {
        super("MainMenu", scn);
    }

    @Override
    public void printMenu() throws SQLException {
        System.out.println("============= MAIN MENU ===============" +
                "\nEnter selection:" +
                "\n\t1) Login" +
                "\n\t2) Create an Account" +
                "\n\tQ) Quit Application");
        String input = scn.nextLine();

        switch (input) {
            case "1":
                pm.printThis(new Login(scn));
                break;
            case "2":
                pm.printThis(new CustomerCreation(scn));
                break;
            case "q":
            case "Q":
                scn.close();
                System.out.println("Closing Application. Goodbye!");
                System.exit(0);
                break;
        }
    }
}
