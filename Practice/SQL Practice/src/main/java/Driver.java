import Models.TestModel;
import Utils.ConnectionManager;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Driver
{
    public static void main (String args[])
    {
        TestModel temp;
        Connection conn = null;

        try
        {
            conn = ConnectionManager.getConn();

            String sqlInfo = "SELECT * FROM test_table";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery((sqlInfo));
            List<TestModel> resultList = new ArrayList<>();

            while (rs.next())
            {
                temp = new TestModel(rs.getInt("int"),
                        rs.getString("name"),
                        rs.getString("string"));

                resultList.add(temp);
            }

            for ( TestModel tm : resultList )
            {
                System.out.println(tm);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
