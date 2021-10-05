package Models;

import java.sql.Date;

public class Transaction {
    private int ACCOUNT_ID;
    private Date DATE;
    private int STARTING_BALANCE;
    private int NEW_BALANCE;
    private String DESCRIPTION;

    public Transaction(int ACCOUNT_ID, Date DATE, int STARTING_BALANCE, int NEW_BALANCE, String DESCRIPTION){
        this.ACCOUNT_ID = ACCOUNT_ID;
        this.DATE = DATE;
        this.STARTING_BALANCE = STARTING_BALANCE;
        this.NEW_BALANCE = NEW_BALANCE;
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getACCOUNT_ID() {
        return ACCOUNT_ID;
    }

    public void setACCOUNT_ID(int ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public int getSTARTING_BALANCE() {
        return STARTING_BALANCE;
    }

    public void setSTARTING_BALANCE(int STARTING_BALANCE) {
        this.STARTING_BALANCE = STARTING_BALANCE;
    }

    public int getNEW_BALANCE() {
        return NEW_BALANCE;
    }

    public void setNEW_BALANCE(int NEW_BALANCE) {
        this.NEW_BALANCE = NEW_BALANCE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
}
