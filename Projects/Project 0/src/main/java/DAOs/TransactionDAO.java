package DAOs;

import Models.Transaction;
import MyCollections.MyArrayList;

import java.sql.*;

public class TransactionDAO implements BankDAO<Transaction>{
    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Used to store a list of transactions
     */
    private MyArrayList<Transaction> transactions;

    private Transaction currentTransaction;

    public TransactionDAO(Connection conn){
        transactions = new MyArrayList<>();
        this.conn = conn;
    }

    /**
     * Saves Transaction data to DB Table
     * @param rowData Transaction object that contains the date to populate the table
     * @throws SQLException
     */
    @Override
    public void save(Transaction rowData) throws SQLException {
        sql = "INSERT INTO TRANSACTIONS " +
                "VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getACCOUNT_ID());
        pstmt.setDate(2, rowData.getDATE());
        pstmt.setInt(3, rowData.getSTARTING_BALANCE());
        pstmt.setInt(4, rowData.getNEW_BALANCE());
        pstmt.setString(4, rowData.getDESCRIPTION());
        pstmt.executeUpdate(sql);
    }

    /**
     * Pull all Transaction data from the DB
     * @return ArrayList of transaction objects
     * @throws SQLException
     */
    @Override
    public MyArrayList<Transaction> getAll() throws SQLException {
        sql = "SELECT * FROM TRANSACTIONS";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next())
        {
            Transaction currentTransaction = new Transaction(rs.getInt("OTHER_ACC"),
                    rs.getInt("ACCOUNT_ID"),
                    rs.getDate("DATE"),
                    rs.getInt("STARTING_BALANCE"), rs.getInt("NEW_BALANCE"),
                    rs.getString("DESCRIPTION"));
            transactions.add(currentTransaction);
        }

        return transactions;
    }

    /**
     * Empty override as this will not be necessary
     */
    @Override
    public void deleteByID(int ID) throws SQLException{

    }

    /**
     * Receives all Transaction data dependent on the parameter ID
     * @param ID The Account ID to go by
     * @return An ArrayList of Transaction objects
     * @throws SQLException
     */
    @Override
    public MyArrayList<Transaction> getByID(int ID) throws SQLException{
        try {
            sql = "SELECT * FROM TRANSACTIONS t " +
                    "JOIN AC_JUNCTION aj ON aj.ACCOUNT_ID = t.ACCOUNT_ID " +
                    "JOIN ACCOUNTS a ON a.ACCOUNT_ID = aj.ACCOUNT_ID " +
                    "WHERE a.ACCOUNT_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentTransaction = new Transaction(rs.getInt("OTHER_ACC"),
                        rs.getInt("ACCOUNT_ID"),
                        rs.getDate("TRANSACTION_DATE"),
                        rs.getInt("STARTING_BALANCE"),
                        rs.getInt("ENDING_BALANCE"),
                        rs.getString("DESCRIPTION"));
                transactions.add(currentTransaction);
            }
        } catch (SQLException e){
            System.out.println("Incorrect table name. Can not fetch data from database.");
        }

        return transactions;
    }

    /**
     * Receives all Transaction data dependent on the parameter ID
     * @param ID The Customer ID to go by
     * @return An ArrayList of Transaction objects
     * @throws SQLException
     */
    public MyArrayList<Transaction> getAllByCID(int ID) throws SQLException{
        transactions.clear();

        try{
            sql = "SELECT * FROM TRANSACTIONS t " +
                    "JOIN AC_JUNCTION aj ON aj.ACCOUNT_ID = t.ACCOUNT_ID " +
                    "JOIN CUSTOMERS c ON c.CUSTOMER_ID = aj.CUSTOMER_ID " +
                    "WHERE c.CUSTOMER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentTransaction = new Transaction(rs.getInt("OTHER_ACC"),
                        rs.getInt("ACCOUNT_ID"),
                        rs.getDate("TRANSACTION_DATE"),
                        rs.getInt("STARTING_BALANCE"),
                        rs.getInt("ENDING_BALANCE"),
                        rs.getString("DESCRIPTION"));
                transactions.add(currentTransaction);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return transactions;
    }
}
