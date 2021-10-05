/**
 * Accounts DAO, Data Access Object
 * Class that contains operations to access ACCOUNTS information from ~DB~.Accounts
 *
 * @author Kollier Martin
 * @date
 */

package DAOs;

import Menu.PrintManager;
import Models.Account;
import MyCollections.MyArrayList;
import Utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccDAO implements BankDAO<Account> {
    /**
     * Used to store a list of customers in function getAllCustomers()
     */
    private MyArrayList<Account> customers;

    /**
     * Used to store a single customer in function getCustomerByID(int ID)
     */
    private Account currentAccount = null;

    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql = "";
    private PreparedStatement pstmt = null;
    private Connection conn = null;
    private ResultSet rs = null;

    /**
     * Parameterized Constructor that is used to create an Account DAO object
     * On creation, this constructor initializes the 'customers' list as an ArrayList and assigns 'this.conn' as the given conn parameter
     *
     * @param conn
     */
    public AccDAO(Connection conn) {
        customers = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * This method simply creates or updates data for an account in the Accounts table
     * Either Create or Update:
     *  ACCOUNT_ID with getAccID given from parameter
     *  CUSTOMER_ID with getCustID given from parameter
     *  BALANCE with getBalance given from parameter
     *
     * @param rowData
     * @throws SQLException
     */
    @Override
    public void save(Account rowData) throws SQLException {
        sql = "INSERT INTO ACCOUNTS(ACCOUNT_ID, ACCOUNT_TYPE, BALANCE)" +
                "VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getAccID());
        pstmt.setString(2, rowData.getAccType());
        pstmt.setInt(3, rowData.getBalance());
        pstmt.executeUpdate(sql);
    }

    /**
     * This method returns row data of an Account depending on the ACCOUNT_ID column, based on the id parameter:
     * @param ID
     * @return Row data of an Account from the ACCOUNT_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public Account getByID(int ID) throws SQLException {
        sql = "SELECT ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);

        rs = pstmt.executeQuery();

        currentAccount = new Account(rs.getString("ACCOUNT_NAME"), rs.getInt("ACCOUNT_ID"), rs.getString("ACCOUNT_TYPE"), rs.getInt("BALANCE"));

        return currentAccount;
    }

    /**
     * This method returns every piece of data from the ACCOUNTS table
     * @return Every piece of data from the ACCOUNTS table
     * @throws SQLException
     */
    @Override
    public MyArrayList<Account> getAll() throws SQLException {
        sql = "SELECT * FROM ACCOUNTS";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next())
        {
            currentAccount = new Account(rs.getString("ACCOUNT_NAME"), rs.getInt("ACCOUNT_ID"), rs.getString("ACCOUNT_TYPE"), rs.getInt("BALANCE"));

            customers.add(currentAccount);
        }

        return customers;
    }

    /**
     * This method deletes an account on the ACCOUNTS table using its ACCOUNT_ID field
     * @param ID
     * @throws SQLException
     */
    @Override
    public void deleteByID(int ID) throws SQLException {
        sql = "DELETE ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.ACCOUNT_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();
    }

    public int getMaxAccID(){
        int ID = 0;
        try {
            sql = "SELECT MAX(ACCOUNT_ID)" +
                    "FROM ACCOUNTS";

            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()){
                ID = rs.getInt("ACCOUNT_ID");
            }
        } catch (SQLException e) {
            // This should never fail as long as the table is not empty
            e.printStackTrace();
        }

        return ID;
    }

    // Update Account Info with Result Set
    public void updateAccount(ResultSet rs) {
        try {
            while (rs.next()) {
                PrintManager.getPM().getCurrentAccount().setAccID(rs.getInt("ACCOUNT_ID"));
                PrintManager.getPM().getCurrentAccount().setAccType(rs.getString("ACCOUNT_TYPE"));
                PrintManager.getPM().getCurrentAccount().setBalance(rs.getInt("BALANCE"));
            }
        } catch (SQLException e) {
            System.out.println("Invalid data type has been used in the updating of this account. Try again.");
        }
    }

    // Withdraw
    public boolean withdrawFunds(int amount) {
        boolean success = false;

        updateAccount(getAllData());

        try {
            if (amount > PrintManager.getPM().getCurrentAccount().getBalance()) {
                System.out.println("You have insufficient funds for this transaction.");
                success = false;
            } else {
                sql = "UPDATE ACCOUNTS" +
                        "SET BALANCE = (BALANCE - ?)" +
                        "WHERE ACCOUNT_ID = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, amount);
                pstmt.setInt(2, PrintManager.getPM().getCurrentAccount().getAccID());

                if (pstmt.executeUpdate(sql) != 0) {
                    System.out.println(amount + " has been withdrawn from your account.");
                    success = true;
                }
            }
        } catch (SQLException e) {
            NullAccount(PrintManager.getPM().getCurrentAccount().getBalance());
            success = false;
        }

        return success;
    }

    // Deposit
    public boolean depositFunds(int amount) throws SQLException {
        boolean success = false;

        sql = "UPDATE ACCOUNTS" +
                "SET BALANCE = (BALANCE + ?)" +
                "WHERE ACCOUNT_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, amount);
        pstmt.setInt(2, PrintManager.getPM().getCurrentAccount().getAccID());

        if(pstmt.executeUpdate(sql) != 0){
            success = true;
        }

        return success;
    }

    // Transfer Funds
    public boolean transferFunds(int amount, int otherAccID){
        boolean success = false;

        withdrawFunds(amount);

        try {
            sql = "UPDATE ACCOUNTS" +
                    "SET BALANCE = (BALANCE + ?)" +
                    "WHERE ACCOUNT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, amount);
            pstmt.setInt(2, otherAccID);

            if (pstmt.executeUpdate(sql) != 0) {
                System.out.println(amount + " has been deposited to: Account " + otherAccID);
                success = true;
            }
        } catch (SQLException e) {
            NullAccount(otherAccID);
            success = false;
        }

        return success;
    }

    public ResultSet getAllData() {
        try {
            sql = "SELECT * FROM ACCOUNTS " +
                    "WHERE ACCOUNT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, PrintManager.getPM().getCurrentAccount().getAccID());
            rs = pstmt.executeQuery();
        }catch (SQLException e){
            NullAccount(PrintManager.getPM().getCurrentAccount().getAccID());
        }

        return rs;
    }

    private String NullAccount(int accID)
    {
        return "Account with ID : " + accID + " does not exist.";
    }
}
