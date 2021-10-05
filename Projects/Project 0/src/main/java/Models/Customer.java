/**
 * Customer Class
 * Contains the blueprint for a Customer
 *
 * @author Kollier Martin
 * @date
 */

package Models;

public class Customer {
    private int CUSTOMER_ID, ACCOUNT_ID, USER_ID = 0;

    /* Add a level of security to these as they are important */
    private String FIRST_NAME, LAST_NAME, EMAIL = "";

    public Customer() {
    }

    /**
     * Parameterized Constructor.
     *
     * @param LAST_NAME The value that will be set to the LAST_NAME of a {@link #Customer(int, String, String, String)} instance.
     * @param FIRST_NAME The value that will be set to the FIRST_NAME of a {@link #Customer(int, String, String, String)} instance.
     */
    public Customer(int CUSTOMER_ID, String EMAIL, String LAST_NAME, String FIRST_NAME) {
        this.CUSTOMER_ID = CUSTOMER_ID; // Set this to the value from the table
        this.EMAIL = EMAIL;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
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

    public int getUserID() { return USER_ID; }

    public void setUserID(int USER_ID) { this.USER_ID = USER_ID; }

    public String getEMAIL() { return EMAIL; }

    public void setEMAIL(String EMAIL) { this.EMAIL = EMAIL; }

    public String toString() {
        return "Customer " + getCusID() + " - " + getLastName() + ", " + getFirstName();
    }
}
