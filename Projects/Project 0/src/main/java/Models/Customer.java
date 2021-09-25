/**
 * Customer Class
 * Contains the blueprint for a Customer
 *
 * @author Kollier Martin
 * @date
 */

package Models;

public class Customer {
    private int CUSTOMER_ID, ACCOUNT_ID = 0;

    /* Add a level of security to these as they are important */
    private String FIRST_NAME, LAST_NAME, password = "";

    public Customer() {
    }

    /**
     * Parameterized Constructor.
     *
     * @param CUSTOMER_ID The value that will be set to the CUSTOMER_ID of a {@link #Customer(int, String, String)} instance.
     * @param LAST_NAME The value that will be set to the LAST_NAME of a {@link #Customer(int, String, String)} instance.
     * @param FIRST_NAME The value that will be set to the FIRST_NAME of a {@link #Customer(int, String, String)} instance.
     */
    public Customer(int CUSTOMER_ID, String LAST_NAME, String FIRST_NAME) {
        this.CUSTOMER_ID = CUSTOMER_ID; // Set this to the value from the table
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        // this.ACCOUNT_ID = 0; // Set this to the value from the table
        // this.password = password; // Randomly generate? No, have user create a password then store it... but where to store it?
    }

    public int getCusID() {
        return CUSTOMER_ID;
    }

    public void setCusID (int CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public int getAccID() {
        return ACCOUNT_ID;
    }

    public void setAccID(int ACCOUNT_ID) {
        this.ACCOUNT_ID = ACCOUNT_ID;
    }

    public String getFirstName() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public void setLastName(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Customer " + getCusID() + " - " + getLastName() + ", " + getFirstName();
    }
}
