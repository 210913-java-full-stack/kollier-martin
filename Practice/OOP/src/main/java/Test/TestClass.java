package Test;

import Cars.*;
import MainClasses.*;
import java.util.ArrayList;

public class TestClass
{
    private static Challenger c1 = null;
    private static Charger c2 = null;
    private static Evo c3 = null;
    private static Mustang c4 = null;

    public static void main (String args[])
    {
        ArrayList<Car> randCars = new ArrayList<>();
        int i = 0;

        // Let this main function randomly create cars from the created car classes

        while (true)
        {
            c1 = new Challenger();
            c2 = new Charger();
            c3 = new Evo();
            c4 = new Mustang();
            randCars.add(c1); randCars.add(c2); randCars.add(c3); randCars.add(c4);
            i++;

            if (i <= 3)
            {
                continue;
            }

            System.out.println(randCars);
            break;
        }
    }
}