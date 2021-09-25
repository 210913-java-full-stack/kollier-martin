package Menu;

import java.util.Scanner;

public class LoggedIn {
    public LoggedIn(String username) {
        instanceInit(username);
    }

    private void instanceInit(String username) {
        String input = "";
        Scanner scn = new Scanner(System.in);
        boolean running = true;

        System.out.printf("============= %s ===============" +
                "\nEnter selection:" +
                "\n\n1) View Account Balance" +
                "\n2) Print Transaction History" +
                "\n3) Transfer Funds" +
                "\nQ) Quit to Main Menu", username);

        switch (input) {
            case "1":
                Login loginPrompt = new Login();
            case "2":
                Creation creationPrompt = new Creation();
            case "3":

                break;
            case "q":
            case "Q":
                running = false;
                scn.close();
                System.out.println("Quit Acknowledged. Goodbye!");
                System.exit(0);
                break;
        }
    }

}
