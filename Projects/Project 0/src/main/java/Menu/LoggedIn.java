package Menu;

import DAOs.AccDAO;
import Utils.ConnectionManager;
import Utils.CredentialChecker;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoggedIn extends PrintView {
    public LoggedIn(Scanner scn)
    {
        super("LoggedIn", scn);
    }

    public void printMenu()
    {
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            System.out.printf("\n============= Currently Logged In: %s ===============" +
                    "\nEnter selection:" +
                    "\n\t1) Transfer Funds" +
                    "\n\t2) View Account Balance" +
                    "\n\t3) Print Transaction History" +
                    "\n\tQ) Quit to Main Menu\n", pm.c);

            String input = scn.nextLine();

            switch (input) {
                case "1":
                    int amount = 0;
                    int sendToID = 0;

                    try {
                        FileWriter fileWriter = new FileWriter("transactions.txt", true);
                        fileWriter.write("Starting balance: " +
                                "Successfully sent " + amount +
                                " to account " + sendToID +
                                "New Balance: ");
                    }catch (IOException e)
                    {
                        System.out.println("There was a problem writing to the " + e + " file..");
                    }
                case "2":
                    try {
                        AccDAO accDAO = new AccDAO(ConnectionManager.getConn());
                        accDAO.getByAID(pm.getCurrentCustomer().getAccID());
                    } catch (SQLException | IOException e)
                    {
                        System.out.println("There was a problem with the creation of the Account DAO.");
                    }

                    break;
                case "3":
                    try {
                        FileReader fileReader = new FileReader("transactions.txt");
                    } catch (IOException e)
                    {
                        System.out.println("IOException: " + e);
                    }
                    break;
                case "q":
                case "Q":
                    System.out.println("Successfully logged out!");
                    isLoggedIn = false;
                    break;
            }
        }
    }
}
