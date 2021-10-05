package Menu;

import Models.Account;
import Models.Customer;
import MyCollections.MyArrayList;

import java.util.Scanner;

public class PrintManager<T> {
    private static PrintManager pm;
    private Scanner scn;

    private Customer currentCustomer;
    private Account currentAccount;

    public MyArrayList<PrintView> viewList;

    public PrintManager()
    {
        this.pm = this;
        this.scn = new Scanner(System.in);

        viewList = new MyArrayList<>();
        viewList.add(new CustomerCreation(scn));
        viewList.add(new LoggedIn(scn));
        viewList.add(new Login(scn));
        viewList.add(new MainMenu(scn));
    }

    public static PrintManager getPM()
    {
        if (pm == null)
        {
            pm = new PrintManager();
        }

        return pm;
    }

    public void printThis(T t) {
        Class aClass = t.getClass();

        switch (aClass.toString())
        {
        case "class Menu.MainMenu":

            break;

        case "class Menu.Login":

            break;

        case "class Menu.LoggedIn":

        }
    }

    public Customer getCurrentCustomer(){
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer c){
        this.currentCustomer = c;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
}

