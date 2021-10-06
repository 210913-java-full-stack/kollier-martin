package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import DAOs.AccDAO;
import DAOs.CusDAO;
import Models.Account;
import Utils.ConnectionManager;
import Utils.CredentialChecker;

public class Login extends PrintView {
    public Login(Scanner scn) {
        super(Login.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        CredentialChecker cc = CredentialChecker.getManager();
        CusDAO cusDAO = new CusDAO(ConnectionManager.conn);
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        boolean isLoggingIn = true;

        while (isLoggingIn) {
            System.out.println("============= LOGIN ===============");
            System.out.print("Enter your username: ");
            String userName = scn.nextLine();

            System.out.print("Enter your password: ");
            String passWord = scn.nextLine();

            if (cc.verifyUser(userName, passWord)) {
                System.out.println("Login successful!");

                pm.setCurrentCustomer(cusDAO.getByName(userName));
                pm.setCurrentAccount(accDAO.getAllByUsername(userName).get(0)); // Active account is the customer's first account

                pm.navigate("class Menu.LoggedIn");
                isLoggingIn = false;
            } else {
                System.out.println("Password is incorrect! Try again?");
                System.out.print("-> ");
                String input = scn.nextLine();

                switch (input){
                    case "y":
                    case "Y":
                        pm.navigate("class Menu.MainMenu");
                        break;
                    case "n":
                    case "N":
                        pm.navigate("class Menu.Login");
                        break;
                }
            }
        }
    }
}
