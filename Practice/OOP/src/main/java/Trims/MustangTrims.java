package Trims;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MustangTrims implements TrimInteface
{
    GT, EcoBoost, Mach1, GT500;

    // The plan here is to show that enumerators can contain functions and variables within them as well
    // COMMENTS for variable below are in the TrimInterface
    private static final List<MustangTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();
    public static final Random RAND = new Random();

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
        return VALUES.get(RAND.nextInt(SIZE));
    }
}
