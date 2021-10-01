package Menu;

import DAOs.AccDAO;
import MyCollections.MyArrayList;
import Utils.ConnectionManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import Main.Driver;

public class PrintManager<T> {
    private static PrintManager pm;

    public MyArrayList<PrintManager> managerList;

    public PrintManager()
    {
        this.pm = this;

        managerList = new MyArrayList<>();

        managerList.add(new PrintManager<Login>());
        managerList.add(new PrintManager<LoggedIn>());
        managerList.add(new PrintManager<MainMenu>());
        managerList.add(new PrintManager<Creation>());
    }

    public static PrintManager getPM()
    {
        if (pm == null)
        {
            pm = new PrintManager();
        }

        return pm;
    }

    public static printMyView(T t) {
        boolean isCreatingAccount = true, running = true, isLoggingIn = true;

        Scanner scn = new Scanner(System.in);
        String newUserName, newPassword, userName, passWord, firstName, lastName, input;

        JSONObject jObj = new JSONObject();
        JSONParser jParser = new JSONParser();

        Creation create = new Creation();
        Login login = new Login();
        Driver driver = new Driver();

        Class aClass = t.getClass();

        switch (aClass.toString())
        {
        case "class Menu.MainMenu":
            while (running) {


                System.out.println("============= MAIN MENU ===============" +
                        "\nEnter selection:" +
                        "\n\t1) Login" +
                        "\n\t2) Create an Account" +
                        "\n\tQ) Quit");
                input = scn.nextLine();

                switch (input) {
                    case "1":
                        pvl.printMyView(login);
                        break;
                    case "2":
                        pvc.printMyView(create);
                        break;
                    case "q":
                    case "Q":
                        scn.close();
                        System.out.println("Quit Acknowledged. Goodbye!");
                        System.exit(0);
                        break;
                }
            }
        case "class Menu.Login":
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
            break;

        case "class Menu.Creation":
            while (isCreatingAccount) {
                System.out.println("============= ACCOUNT CREATION ===============");
                System.out.print("Enter your first name: ");
                firstName = scn.nextLine();

                System.out.print("Enter your last name: ");
                lastName = scn.nextLine();

                System.out.print("Enter your username: ");
                newUserName = scn.nextLine();

                System.out.print("Enter your password: ");
                newPassword = scn.nextLine();

                if (Creation.checkForIntegrity(firstName, lastName, newUserName, newPassword) == false)
                {
                    Creation.encryptData(jObj, firstName, lastName, newUserName, newPassword);

                    System.out.println("\nAccount creation successful!");
                    System.out.print("Would you like to login now? ");

                    if (scn.nextLine().equalsIgnoreCase("y")) {
                        isCreatingAccount = false;

                        pvl.printMyView(login);
                    } else if (scn.nextLine().equalsIgnoreCase("n")) {
                        isCreatingAccount = false;

                        pvd.printMyView(driver);
                    }
                } else {
                    isCreatingAccount = true;
                }
            }

        case "class Menu.LoggedIn":
            while (running) {
                System.out.printf("\n============= Currently Logged In: %s ===============" +
                        "\nEnter selection:" +
                        "\n\t1) Transfer Funds" +
                        "\n\t2) View Account Balance" +
                        "\n\t3) Print Transaction History" +
                        "\n\tQ) Quit to Main Menu\n", LoggedIn.username);

                input = scn.nextLine();

                switch (input) {
                    case "1":
                        int amount = 0;
                        int sendToID = 0;

                        try {
                            FileWriter fileWriter = new FileWriter("transactions.txt", true);
                            fileWriter.write("Starting balance: " +
                                    "Successfully sent " + amount +
                                    " to account " + sendToID +
                                    "New Balance: ");
                        }catch (IOException e)
                        {
                            System.out.println("There was a problem writing to the " + e + " file..");
                        }
                    case "2":
                        try {
                            AccDAO accDAO = new AccDAO(ConnectionManager.getConn());
                            accDAO.getByName(LoggedIn.username);
                        } catch (SQLException | IOException e)
                        {
                            System.out.println("There was a problem with the creation of the Account DAO.");
                        }

                        break;
                    case "3":
                        try {
                            FileReader fileReader = new FileReader("transactions.txt");
                        } catch (IOException e)
                        {
                            System.out.println("IOException: " + e);
                        }
                        break;
                    case "q":
                    case "Q":
                        System.out.println("Successfully logged out!");
                        running = false;
                        break;
                }
            }
        }
    }
}
