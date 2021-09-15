package Trims;
import Cars.Charger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ChargerTrims implements TrimInteface
{
    SXT, SXTAWD, GT, RT, ScatPack, Hellcat, HellcatRedeye;

    // The plan here is to show that enumerators can contain functions and variables within them as well
    // COMMENTS for variable below are in the TrimInterface
    private static final List<ChargerTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();
    public static final Random RAND = new Random();

    @Override
    public String toString()
    {
        String name = "";
        switch (this)
        {
            case SXT:
                name = "SXT";
                break;
            case SXTAWD:
                name = "SXT AWD";
                break;
            case GT:
                name = "GT";
                break;
            case RT:
                name = "RT";
                break;
            case ScatPack:
                name = "Scat Pack";
                break;
            case Hellcat:
                name = "Hellcat";
                break;
            case HellcatRedeye:
                name = "Hellcat Redeye";
                break;
        }
        return name;
    }

    public static ChargerTrims getRandTrim()
    {
        return VALUES.get(RAND.nextInt(SIZE));
    }
}
