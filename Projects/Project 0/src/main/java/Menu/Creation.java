package Menu;

import DAOs.*;
import Models.*;
import Utils.ConnectionManager;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Creation{
    public Creation() {
    }

    public static boolean checkForIntegrity(String firstName, String lastName, String newUserName, String newPassword)
    {
        Connection conn = null;

        try {
            conn = ConnectionManager.getConn();
        }
        catch (SQLException e)
        {
            System.out.println("SQLException: " + e);
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }

        CusDAO cusDAO = new CusDAO(conn);
        Customer customer;
        boolean notGood = true;

        if((newUserName != null && newPassword != null && firstName != null && lastName != null)
            || (firstName.isEmpty() && lastName.isEmpty() && newUserName.isEmpty() && newPassword.isEmpty()))
        {
            customer = new Customer(lastName, firstName);

            try{
                cusDAO.save(customer);
            }catch (SQLException e)
            {

            }

            notGood = false;
        }

        return notGood;
    }

    public static void encryptData(JSONObject jObj, String firstName, String lastName, String userName, String passWord) {
        FileWriter fileWriter;

        String credentials = "src/main/resources/credentials.json";

        try {
            Connection conn = ConnectionManager.getConn();
        }
        catch (SQLException e)
        {
            System.out.println("SQLException: " + e);
        }
        catch (IOException e)
        {
            System.out.println("IOException: " + e);
        }

        jObj.put("firstname", firstName);
        jObj.put("lastname", lastName);
        jObj.put("username", userName);
        jObj.put("password", passWord);

        try {
            fileWriter = new FileWriter(credentials, true);
            fileWriter.write("\n" + jObj.toJSONString());
            fileWriter.close();
        } catch (IOException e)
        {
            System.out.println("Can not write to file: " + e + "\nCheck permissions and try again.");
        }
    }
}
