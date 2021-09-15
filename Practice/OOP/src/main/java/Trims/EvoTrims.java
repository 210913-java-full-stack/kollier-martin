package Trims;
import Cars.Evo;

import java.util.Random;

public enum EvoTrims
{
    MR, GSR, Final;

    @Override
    public String toString()
    {
        String name = "";
        switch (this)
        {
            case MR:
                name = "GR";
                break;
            case GSR:
                name = "MSR";
                break;
            case Final:
                name = "Final";
                break;
        }
        return name;
    }

    public static EvoTrims getRandTrim()
    {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
