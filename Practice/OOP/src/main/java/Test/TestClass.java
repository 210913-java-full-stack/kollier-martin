package Test;

import Cars.*;
import Trims.*;
import MainClasses.*;
import Trims.MustangTrims;

import java.util.ArrayList;
import java.util.Random;

public class TestClass
{
    private static Challenger c1;
    private static Charger c2;
    private static Evo c3;
    private static Mustang c4;

    public static void main (String args[])
    {
        // Let this main function randomly create cars from the created car classes
        // FIXME Becomes null when doing 'getRandTrim()'

        ArrayList<Car> randCars = new ArrayList<Car>();

        c1 = new Challenger(ChallengerTrims.getRandTrim());
        c2 = new Charger(ChargerTrims.getRandTrim());
        c3 = new Evo(EvoTrims.getRandTrim());
        c4 = new Mustang(MustangTrims.getRandTrim());

        randCars.add(c1);
        randCars.add(c2);
        randCars.add(c3);
        randCars.add(c4);

        System.out.println(randCars.toString());
    }
}