package Main;

import Menu.*;

public class Driver {
    public Driver() {}

    public static void main(String args[]) {
        boolean running = true;

        PrintManager pm = new PrintManager.getPM();

        Driver driver = new Driver();


        while (running) {
            Menu currentMenu = new MainMenu();
            pm.printMyView(currentMenu);
        }
    }
}
