package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import Models.Customer;
import Utils.CredentialChecker;

public class Login extends PrintView {
    public Login(Scanner scn) {
        super("Login", scn);
    }

    @Override
    public void printMenu() throws SQLException {
        CredentialChecker cc = CredentialChecker.getManager();
        boolean isLoggingIn = true;

        while (isLoggingIn) {
            System.out.println("============= LOGIN ===============");
            System.out.print("Enter your username: ");
            String userName = scn.nextLine();

            System.out.print("Enter your password: ");
            String passWord = scn.nextLine();

            if (cc.verifyUser(userName, passWord)) {
                System.out.println("Login successful!");


                pm.printThis(new LoggedIn(scn));

                isLoggingIn = false;
            } else {
                System.out.println("Password is incorrect! Try again.");
                isLoggingIn = true;
            }
        }
    }
}
