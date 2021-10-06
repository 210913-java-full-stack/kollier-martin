package Menu;

import DAOs.AccDAO;
import DAOs.TransactionDAO;
import Models.Account;
import Models.Transaction;
import MyCollections.MyArrayList;
import Utils.ConnectionManager;

import java.sql.Date;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TransferFunds extends PrintView{

    public TransferFunds(Scanner scn){
        super(TransferFunds.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        Date sqlDate = new Date(System.currentTimeMillis());
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);

        AccDAO accDAO = new AccDAO(ConnectionManager.conn);
        TransactionDAO tDAO = new TransactionDAO(ConnectionManager.conn);

        MyArrayList<Account> accounts;

        boolean isTransferring = true;

        String amount, accID, sendToID;
        int amountI, accIDI, sendToIDI;

        System.out.printf("\n============= %s's Transfer Page ===============", pm.getCurrentCustomer().getFirstName());


        while(isTransferring) {
            System.out.println("\nBalance for Account(s):");
            try {
                accounts = accDAO.getAllByFirstName(pm.getCurrentCustomer().getFirstName());

                // Print available accounts
                for (Account acc : accounts) {
                    System.out.printf("\n\t%d : [%s]", acc.getAccID(), formatter.format(acc.getBalance()));
                }

                System.out.println();

                System.out.println("Choose the account in which you would like to transfer from: ");
                accID = scn.nextLine();

                System.out.println("Input transfer amount: ");
                amount = scn.nextLine();

                System.out.println("Input any Account ID from within the database where you would like to transfer:");
                sendToID = scn.nextLine();

                accIDI = Integer.parseInt(accID); sendToIDI = Integer.parseInt(sendToID); amountI = Integer.parseInt(amount);

                // Store Transaction
                tDAO.save(new Transaction(sendToIDI,
                        accIDI,
                        sqlDate,
                        accDAO.getAccByID(accIDI).getBalance(),
                        accDAO.getAccByID(accIDI).getBalance() + amountI,
                        ("Successfully transferred " + amount + " to Account: " + accID + "!")));

                // Transfer Funds
                accDAO.transferFunds(amountI, accIDI, sendToIDI);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pm.navigate("class Menu.LoggedIn");
    }
}
