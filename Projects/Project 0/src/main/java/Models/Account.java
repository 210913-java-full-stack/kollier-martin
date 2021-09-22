package Models;

public class Account
{
    // TODO: Set up connection to DB and relate variables to pulled data
    int custID, accID, balance = 0;

    public Account()
    {
    }

    public Account(int custID, int accID, int balance) {
        this.custID = custID;
        this.accID = accID;
        this.balance = balance;
    }

    // Withdraw

    // Deposit

    // Transfer Funds

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
