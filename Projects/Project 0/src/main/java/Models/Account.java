package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Account
{
    private int CUSTOMER_ID, ACCOUNT_ID, BALANCE = 0;

    public Account()
    {
    }

    public Account(int ACCOUNT_ID, int CUSTOMER_ID, int BALANCE) {
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.BALANCE = BALANCE;
    }

    // Withdraw
    public void withdrawFunds(int amount)
    {
        // TODO: configure the withdrawal of funds from account


        /*try (rs.next())
        {
            conn = ConnectionManager.getConn();
        } catch (SQLException | IOException e)
        {
            //TODO: Handle this exception
        }*/
    }

    // Deposit
    public void depositFunds(int amount)
    {
        // TODO: configure the deposit of funds to account
    }

    // Transfer Funds
    public void transferFunds(int amount, int otherCustID)
    {
        // OPTIONAL
        // TODO: configure the transfer of funds to another account
    }

    public int getCustID() {
        return CUSTOMER_ID;
    }

    public void setCustID(int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

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
