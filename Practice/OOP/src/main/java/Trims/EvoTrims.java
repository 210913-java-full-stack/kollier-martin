package Trims;
import Cars.Evo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EvoTrims implements TrimInteface
{
    MR, GSR, Final;

    // The plan here is to show that enumerators can contain functions and variables within them as well
    // COMMENTS for variable below are in the TrimInterface
    private static final List<EvoTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();
    public static final Random RAND = new Random();

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
        return VALUES.get(RAND.nextInt(SIZE));
    }
}
