package DAOs;

import Models.UserInfo;
import MyCollections.MyArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements BankDAO<UserInfo>{
    /**
     * All SQL parameters used to run and store a query within the program
     */
    private String sql;
    private PreparedStatement pstmt = null;
    private Connection conn;
    private ResultSet rs = null;

    /**
     * Used to store a list of customers in function getAllCustomers()
     */
    private MyArrayList<UserInfo> userInfoArrayList;

    /**
     * Used to store a single customer in function getCustomerByID(int ID)
     */
    private UserInfo currentUser = null;

    public UserDAO(Connection conn){
        userInfoArrayList = new MyArrayList<>();
        this.conn = conn;
    }

    @Override
    public void save(UserInfo row) throws SQLException {

    }

    @Override
    public MyArrayList<UserInfo> getAll() throws SQLException {
        try {
            sql = "SELECT * FROM USERINFO";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                currentUser = new UserInfo(rs.getString("USER_NAME"),
                        rs.getString("PASSWORD"),
                        rs.getInt("USER_ID"));
                userInfoArrayList.add(currentUser);
            }
        } catch (SQLException e){
            System.out.println("Incorrect table name. Can not fetch data from database.");
        }

        return userInfoArrayList;
    }

    @Override
    public void deleteByID(int ID) throws SQLException {

    }

    @Override
    public UserInfo getByID(int ID) throws SQLException {
        UserInfo temp = null;

        try {
            sql = "SELECT u.USER_NAME, u.PASSWORD, u.USER_ID" +
                    "FROM USERINFO u" +
                    "JOIN CUSTOMERS c ON c.USER_ID = u.USER_ID" +
                    "WHERE c.CUSTOMER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ID);
            rs = pstmt.executeQuery();

            temp = new UserInfo(rs.getString("USER_NAME"),
                    rs.getString("PASSWORD"),
                    rs.getInt("USER_ID"));
        } catch (SQLException e){
            System.out.println("Table is not properly formatted or is invalid. Can not fetch data.");
        }

        return temp;
    }

}
