/*
 * Kyle's code to show to connect to a DB
 *
 */

package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionManager
{
    private static Connection conn;
    private static String myDBProp = "src/main/resources/db_properties.properties";

    private ConnectionManager()
    {

    }

    public static Connection getConn() throws SQLException, IOException
    {
        if (conn == null)
        {
            Properties prop = new Properties();
            // Change me dependent on property file to attack
            FileReader propertiesFile = new FileReader(myDBProp);
            prop.load(propertiesFile);

            String connString = "jdbc:mariadb://" +
                    prop.getProperty("hostname") + ":" +
                    prop.getProperty("port") + "/" +
                    prop.getProperty("databaseName") + "?user=" +
                    prop.getProperty("user") + "&password=" +
                    prop.getProperty("password");

            conn = DriverManager.getConnection(connString);
        }

        return conn;
    }
}
