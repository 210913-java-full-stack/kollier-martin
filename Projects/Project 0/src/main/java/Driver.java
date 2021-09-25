import Menu.*;

import java.util.Scanner;

public class Driver {
    private static Scanner scn;
    private static String input = scn.nextLine();
    private static boolean running;

    public static void main(String args[]) {
        //region Main Loop
        while (running) {
            System.out.println("============= MAIN MENU ===============" +
                    "\nEnter selection:" +
                    "\n\n1) Login" +
                    "\n2) Create an Account" +
                    "\nQ) Quit");

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
}
