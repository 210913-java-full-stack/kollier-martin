/**
 * Customers DAO, Data Access Object
 * Class that contains operations to access CUSTOMERS information from ~DB~.Accounts
 *
 * @author Kollier Martin
 * @date
 */

package DAOs;

import Models.Customer;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CusDAO implements BankDAO<Customer>{
    /**
     * Used to store a list of customers in function getAllCustomers()
     */
    private MyArrayList<Customer> customers;

    /**
     * Used to store a single customer in function getCustomerByID(int ID)
     */
    private Customer currentCustomer = null;

    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Parameterized Constructor that is used to create a Customer DAO object
     * On creation, this constructor initializes the 'customers' list as an ArrayList and assigns 'this.conn' as the given conn parameter
     *
     * @param conn
     */
    public CusDAO(Connection conn) {
        customers = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * This method simply creates or updates data for an account in the Accounts table
     * Either Create or Update:
     *  CUSTOMER_ID with getCusID given from parameter
     *  LAST_NAME with getLastName given from parameter
     *  FIRST_NAME with getFirstName given from parameter
     *
     * @param rowData
     * @throws SQLException
     */
    @Override
    public void save(Customer rowData) throws SQLException {
        // INSERT IGNORE INTO or REPLACE???
        /*sql = "INSERT IGNORE INTO CUSTOMERS" +
                "SET CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getCusID());
        pstmt.executeUpdate(sql);*/

        sql = "INSERT IGNORE INTO CUSTOMERS" +
                "SET LAST_NAME = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, rowData.getLastName());
        pstmt.executeUpdate(sql);

        sql = "INSERT IGNORE INTO CUSTOMERS" +
                "SET FIRST_NAME = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, rowData.getFirstName());
        pstmt.executeUpdate(sql);
    }

    /**
     * This method returns row data of a Customer depending on the CUSTOMER_ID column, based on the id parameter
     * @param ID
     * @return Row data of an Account from the CUSTOMER_ID column based on the id parameter
     * @throws SQLException
     */
    @Override
    public Customer getByCID(int ID) throws SQLException {
        sql = "SELECT CUSTOMERS c FROM CUSTOMERS" +
                "WHERE c.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

        currentCustomer = new Customer(rs.getInt("CUSTOMER_ID"), rs.getString("LAST_NAME"), rs.getString("FIRST_NAME"));

        return currentCustomer;
    }

    /**
     * This method returns every piece of data from the CUSTOMERS table
     * @return Every piece of data from the CUSTOMERS table
     * @throws SQLException
     */
    @Override
    public MyArrayList<Customer> getAll() throws SQLException {
        sql = "SELECT * FROM CUSTOMERS";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next())
        {
            currentCustomer = new Customer(rs.getInt("CUSTOMER_ID"), rs.getString("LAST_NAME"), rs.getString("FIRST_NAME"));
            customers.add(currentCustomer);
        }

        return customers;
    }

    /**
     * This method deletes an account on the CUSTOMERS table using its CUSTOMER_ID field
     * @param ID
     * @throws SQLException
     */
    @Override
    public void deleteByID(int ID) throws SQLException {
        sql = "DELETE CUSTOMERS c FROM CUSTOMERS" +
                "WHERE c.CUSTOMER_ID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ID);
        rs = pstmt.executeQuery();

    }
}
