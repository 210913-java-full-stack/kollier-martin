package Menu;

import java.util.Scanner;

public class LoggedIn implements PrintView {
    public static String username = "";

    private boolean isLoggingIn;
    private Scanner scn = new Scanner(System.in);

    public LoggedIn(String username)
    {
        this.username = username;
    }

    public void printMenu()
    {
        String userName, passWord;

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
