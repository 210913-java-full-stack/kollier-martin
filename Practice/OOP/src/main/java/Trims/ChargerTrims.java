package Trims;
import java.util.Random;

public enum ChargerTrims
{
    SXT, SXTAWD, GT, RT, ScatPack, Hellcat, HellcatRedeye;

    @Override
    public String toString()
    {
        String name = "";
        switch (this)
        {
            case SXT:
                name = ("SXT");
                break;
            case Hellcat:
                name = ("Hellcat");
                break;
            case ScatPack:
                name = ("Scat Pack");
                break;
            case HellcatRedeye:
                name = ("Hellcat Redeye");
                break;
            case RT:
                name = ("RT");
                break;
        }
        return name;
    }

    public static ChargerTrims getRandTrim()
    {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
