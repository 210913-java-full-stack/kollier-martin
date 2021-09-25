package Menu;

import org.json.simple.JSONObject;

import java.util.Scanner;

public class Creation{
    public Creation() {
        instanceInit();
    }

    private void instanceInit() {
        Scanner scn = new Scanner(System.in);
        String newUserName, newPassword;
        Login logInPrompt;
        JSONObject jObj = new JSONObject();
        boolean isCreatingAccount = true;

        while(isCreatingAccount) {
            System.out.print("Enter your username: ");
            newUserName = scn.nextLine();

            System.out.println("\n");

            System.out.print("Enter your password: ");
            newPassword = scn.nextLine();

            if ((newUserName != null && newPassword != null) || (newUserName.isEmpty() && newPassword.isEmpty())){
                encryptData(jObj, newUserName, newPassword);
                System.out.println("Account creation successful!");
                System.out.print("Would you like to login now? ");

                if (scn.nextLine().equalsIgnoreCase("y"))
                {
                    isCreatingAccount = false;
                    logInPrompt = new Login();
                    logInPrompt.instanceInit();
                } else if (scn.nextLine().equalsIgnoreCase("n")){
                    isCreatingAccount = false;
                }
            }
            else {
                isCreatingAccount = true;
            }
        }
    }

    private void encryptData(JSONObject jObj, String userName, String passWord) {
        jObj.put("username", userName);
        jObj.put("password", passWord);
    }
}
