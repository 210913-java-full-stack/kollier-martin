package Main;

import Menu.*;

public class Driver {
    public Driver() {}

    public static void main(String args[]) {
        boolean running = true;

        PrintManager pm = PrintManager.getPM();

        while (running) {
            pm.printThis(new MainMenu());
        }
    }
}
