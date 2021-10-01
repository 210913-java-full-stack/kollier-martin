package Menu;

import java.io.FileReader;
import java.io.IOException;

import Utils.PasswordUtil;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Login {
    PasswordUtil passwordManager = PasswordUtil.getManager();
    public Login(){
    }

    public static boolean authenticateUser(JSONParser jParser, JSONObject jObj, String userName, String passWord){
        jObj = decodeData(jParser, jObj);

        String tempUser = (String) jObj.get("username");
        String tempPword = (String) jObj.get("password");

        boolean isAuthentic;

        if (tempUser.equals(userName) && tempPword.equals(passWord))
        {
            isAuthentic = true;
        }
        else
        {
            isAuthentic = false;
        }

        return isAuthentic;
    }

    private static JSONObject decodeData(JSONParser jParser, JSONObject jObj) {
        try {
            jObj = (JSONObject) jParser.parse(new FileReader("src/main/resources/credentials.json"));
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return jObj;
    }

    private void printMenu()
    {
        String userName, passWord
        while (isLoggingIn) {
            System.out.println("============= LOGIN ===============");
            System.out.print("Enter your username: ");
            userName = scn.nextLine();

            System.out.print("Enter your password: ");
            passWord = scn.nextLine();

            if (Login.authenticateUser(jParser, jObj, userName, passWord)) {
                System.out.println("Login successful!");

                LoggedIn loggedIn = new LoggedIn(userName);
                pvli.printMyView(loggedIn);

                isLoggingIn = false;
            } else {
                System.out.println("Password is incorrect! Try again.");
                isLoggingIn = true;
            }
        }
    }
}
