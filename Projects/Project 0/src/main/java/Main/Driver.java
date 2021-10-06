package Main;

import Utils.ConnectionManager;
import Utils.PrintManager;

import java.sql.SQLException;

public class Driver {
    public Driver() {}

    public static void main(String args[]) {
        boolean running = true;

        PrintManager pm = PrintManager.getPM();
        ConnectionManager.getConn();

        pm.navigate("class Menu.MainMenu");

        while(running){
            try{
                pm.printThis();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
