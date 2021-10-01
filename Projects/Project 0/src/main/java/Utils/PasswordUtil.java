package Utils;

public class PasswordUtil {
    private static PasswordUtil pManager;

    // create pManager
    public static PasswordUtil createManager()
    {
        if (pManager == null)
        {
            pManager = new PasswordUtil();
        }

        return pManager;
    }

    // encrypt
        // using Customer arg
    // decrypt
        // return Customer
}
