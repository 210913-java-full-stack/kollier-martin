package Test;

import Cars.*;
import Trims.*;

public class TestClass
{
    public static void main (String args[])
    {
        Mustang ECO = new Mustang(MustangTrims.EcoBoost);

        System.out.println(ECO.toString());
    }
}