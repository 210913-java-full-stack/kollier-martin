package Menu;

import DAOs.CusDAO;
import Utils.ConnectionManager;
import Utils.CredentialChecker;

import java.util.Scanner;

public class CustomerCreation extends PrintView {
    public CustomerCreation(Scanner scn) {
        super("Creation", scn);
    }

    @Override
    public void printMenu() {
        CusDAO cusDAO = new CusDAO(ConnectionManager.conn);
        boolean isCreatingAccount = true;
        CredentialChecker cc = new CredentialChecker();
        String firstName, lastName, newUserName, newPassword;

        while (isCreatingAccount) {
            System.out.println("============= ACCOUNT CREATION ===============");
            System.out.print("Enter your first name: ");
            firstName = scn.nextLine();

            System.out.print("Enter your last name: ");
            lastName = scn.nextLine();

            System.out.print("Enter your username: ");
            newUserName = scn.nextLine();

            System.out.print("Enter your password: ");
            newPassword = scn.nextLine();

            if (cc.isValid(newUserName, newPassword))
            {
                // CusDAO save

                System.out.println("\nAccount creation successful!");
                System.out.print("Would you like to login now? ");

                if (scn.nextLine().equalsIgnoreCase("y")) {
                    isCreatingAccount = false;

                    pm.printThis(new Login(scn));
                } else if (scn.nextLine().equalsIgnoreCase("n")) {
                    isCreatingAccount = false;

                    pm.printThis(new MainMenu(scn));
                }
            } else {
                isCreatingAccount = true;
            }
        }
    }
}
