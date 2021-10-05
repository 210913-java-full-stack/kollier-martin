package Models;

import Utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account
{
    private int ACCOUNT_ID, BALANCE = 0;
    private String ACCOUNT_TYPE, ACCOUNT_NAME = "";

    private String sql;
    private PreparedStatement pstmt;
    private Connection conn;
    private ResultSet rs;

    public Account() {
        this.conn = ConnectionManager.conn;
    }

    public Account(String ACCOUNT_NAME, int ACCOUNT_ID, String ACCOUNT_TYPE, int BALANCE) {
        this.conn = ConnectionManager.conn;
        this.ACCOUNT_NAME = ACCOUNT_NAME;
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.ACCOUNT_TYPE = ACCOUNT_TYPE;
        this.BALANCE = BALANCE;
    }

    public String getACCOUNT_NAME() {
        return ACCOUNT_NAME;
    }

    public void setACCOUNT_NAME(String ACCOUNT_NAME) {
        this.ACCOUNT_NAME = ACCOUNT_NAME;
    }

    public String getAccType() {
        return ACCOUNT_TYPE;
    }

    public void setAccType(String ACCOUNT_TYPE) { this.ACCOUNT_TYPE = ACCOUNT_TYPE; }

    public int getAccID() {
        return ACCOUNT_ID;
    }

    public void setAccID(int ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public int getBalance() {
        return BALANCE;
    }

    public void setBalance(int BALANCE) {
        this.BALANCE = BALANCE;
    }
}
