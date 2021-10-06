package Menu;

import DAOs.TransactionDAO;
import Models.Transaction;
import Utils.ConnectionManager;

import java.sql.SQLException;
import java.util.Scanner;

public class TransactionHistory extends PrintView{

    public TransactionHistory(Scanner scn){
        super(TransactionHistory.class, scn);
    }

    @Override
    public void printMenu() throws SQLException {
        TransactionDAO tDao = new TransactionDAO(ConnectionManager.conn);

        for (Transaction t : tDao.getAllByCID(pm.getCurrentCustomer().getCusID())){
            System.out.println(t.toString());
        }
    }
}
