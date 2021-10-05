package Menu;

import DAOs.AccDAO;
import Models.Account;
import Utils.ConnectionManager;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountCreation extends PrintView {
    public AccountCreation(Scanner scn) {
        super("AccountCreation", scn);
    }

    @Override
    public void printMenu() throws SQLException {
        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        Account newAccount = new Account();
        boolean isCreatingAccount = true;
        String accountType, input;

        System.out.println("============= BANK ACCOUNT CREATION ===============");
        while (isCreatingAccount) {
            System.out.print("Input what kind of account you would like to make [Checking or Savings]: ");
            accountType = scn.nextLine();

            if (!(accountType.equalsIgnoreCase("Checking")) && !(accountType.equalsIgnoreCase("Savings"))) {
                System.out.println("Please input a valid option.");
                isCreatingAccount = true;

            } else {
                newAccount.setAccType(accountType);
                newAccount.setBalance(0);

                System.out.print("Would you like to name your account? (Y/N): ");
                input = scn.nextLine();

                switch (input) {
                    case "Y":
                    case "y":
                        System.out.println("Please enter the name for this account: ");
                        input = scn.nextLine();
                        newAccount.setACCOUNT_NAME(input);

                        System.out.println("Account creation successful!");
                        pm.printThis(new LoggedIn(scn));
                        break;

                    case "N":
                    case "n":
                        System.out.println("Account creation successful!");
                        pm.printThis(new LoggedIn(scn));
                        break;
                }
            }
        }
    }
}