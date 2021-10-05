package DAOs;

import Models.Account;
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

    public TransactionDAO(Connection conn){
        transactions = new MyArrayList<>();
        this.conn = conn;
    }

    @Override
    public void save(Transaction rowData) throws SQLException {
        sql = "INSERT INTO TRANSACTIONS" +
                "VALUES (?, ?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, rowData.getACCOUNT_ID());
        pstmt.setDate(2, rowData.getDATE());
        pstmt.setInt(3, rowData.getSTARTING_BALANCE());
        pstmt.setInt(4, rowData.getNEW_BALANCE());
        pstmt.setString(4, rowData.getDESCRIPTION());
        pstmt.executeUpdate(sql);
    }

    @Override
    public MyArrayList<Transaction> getAll() throws SQLException {
        sql = "SELECT * FROM ACCOUNTS";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while(rs.next())
        {
            Transaction currentTransaction = new Transaction(rs.getInt("ACCOUNT_ID"), rs.getDate("DATE"), rs.getInt("STARTING_BALANCE"), rs.getInt("NEW_BALANCE"), rs.getString("DESCRIPTION"));
            transactions.add(currentTransaction);
        }

        return transactions;
    }

    @Override
    public void deleteByID(int ID) throws SQLException{

    }

    @Override
    public Transaction getByID(int ID) throws SQLException{

    }
}
