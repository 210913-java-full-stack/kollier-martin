package Menu;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Login {
    public Login(){
        instanceInit();
    }

    public void instanceInit() {
        Scanner scn = new Scanner(System.in);
        String userName, passWord;
        JSONParser jParser = new JSONParser();
        JSONObject jObj = new JSONObject();

        boolean isLoggingIn = true;

        while(isLoggingIn) {
            System.out.print("Enter your username: ");
            userName = scn.nextLine();

            System.out.println("\n");

            System.out.print("Enter you password: ");
            passWord = scn.nextLine();

            if (authenticateUser(jParser, jObj, userName, passWord))
            {
                System.out.println("Login successful!");
                LoggedIn inMenu = new LoggedIn(userName);
                isLoggingIn = false;
            }
            else {
                isLoggingIn = true;
            }
        }
    }

    private boolean authenticateUser(JSONParser jParser, JSONObject jObj, String userName, String passWord){
        decodeData(jParser, jObj, userName, passWord);

        String tempUser = (String) jObj.get("username");
        String tempPword = (String) jObj.get("password");

        boolean isAuthentic;

        if (tempUser == userName && tempPword == passWord)
        {
            isAuthentic = true;
        }
        else
        {
            isAuthentic = false;
        }

        return isAuthentic;
    }

    private void decodeData(JSONParser jParser, JSONObject jObj, String userName, String passWord) {
        try {
            jObj = (JSONObject) jParser.parse(new FileReader("src/main/resources/credentials.json"));
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
