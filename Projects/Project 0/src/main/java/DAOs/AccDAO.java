/**
 * Accounts DAO, Data Access Object
 * Class that contains operations to access ACCOUNTS information from ~DB~.Accounts
 *
 * @author Kollier Martin
 * @date
 */

package DAOs;

import Models.Account;
import MyCollections.MyArrayList;

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
        // INSERT IGNORE INTO or REPLACE???
        sql = "INSERT IGNORE INTO ACCOUNTS" +
                "SET ACCOUNT_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getAccID());
        pstmt.executeUpdate(sql);

        sql = "INSERT IGNORE INTO ACCOUNTS" +
                "SET CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getCustID());
        pstmt.executeUpdate(sql);

        sql = "INSERT IGNORE INTO ACCOUNTS" +
                "SET BALANCE = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getBalance());
        pstmt.executeUpdate(sql);
    }

    /**
     * This method returns row data of an Account depending on the CUSTOMER_ID column, based on the id parameter
     * @param ID
     * @return Row data of an Account from the CUSTOMER_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public Account getByCID(int ID) throws SQLException {
        sql = "SELECT ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.CUSTOMER_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);

        rs = pstmt.executeQuery();

        currentAccount = new Account(rs.getInt("ACCOUNT_ID"), rs.getInt("CUSTOMER_ID"), rs.getInt("BALANCE"));

        return currentAccount;
    }

    /**
     * This method returns row data of an Account depending on the ACCOUNT_ID column, based on the id parameter:
     * @param ID
     * @return Row data of an Account from the ACCOUNT_ID column based on the id parameter
     * @throws SQLException
     */
    public Account getByAID(int ID) throws SQLException {
        sql = "SELECT ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);

        rs = pstmt.executeQuery();

        currentAccount = new Account(rs.getInt("ACCOUNT_ID"), rs.getInt("CUSTOMER_ID"), rs.getInt("BALANCE"));

        return currentAccount;
    }

    public Account getByName(String customer) throws SQLException
    {
        /*
            SELECT ACCOUNTS

            WHERE c.CUSTOMER_ID
        * */
        sql = "SELECT ACCOUNTS a FROM ACCOUNTS" +
                "WHERE a.ACCOUNT_ID = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, customer);

        rs = pstmt.executeQuery();

        currentAccount = new Account(rs.getInt("ACCOUNT_ID"), rs.getInt("CUSTOMER_ID"), rs.getInt("BALANCE"));

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
            Account currentAccount = new Account(rs.getInt("ACCOUNT_ID"), rs.getInt("CUSTOMER_ID"), rs.getInt("BALANCE"));
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
}
