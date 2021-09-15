package Trims;
import java.util.Random;

public enum MustangTrims
{
    GT, EcoBoost, Mach1, GT500;

    @Override
    public String toString()
    {
        String name = "";
        switch (this)
        {
            case EcoBoost:
                name = "EcoBoost";
                break;
            case GT:
                name = "GT";
                break;
            case Mach1:
                name = "Mach 1";
                break;
            case GT500:
                name = "GT500";
                break;
        }
        return name;
    }

    public static MustangTrims getRandTrim()
    {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
