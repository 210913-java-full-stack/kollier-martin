package Models;

public class Customer {
    // TODO: Set up connection to DB and relate variables to pulled data
    private int custID, accID = 0;

    /* Add a level of security to these as they are important */
    private String userName, passWord = "";

    public Customer() {
    }

    public Customer(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
