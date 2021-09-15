package Trims;
import java.util.Random;

public enum ChallengerTrims
{
    SXT, SXTAWD, GT, RT, ScatPack, Hellcat, HellcatRedeye, SuperStock;

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
            case SuperStock:
                name = ("Super Stock");
                break;
            case RT:
                name = ("RT");
                break;
        }
        return name;
    }

    public static ChallengerTrims getRandTrim()
    {
        Random rand = new Random();
        return values()[rand.nextInt(values().length)];
    }
}
