/**
 * This class contains the trim levels for the Ford Mustang
 * COMMENTS for variables below are in the TrimInterface
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package Trims;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MustangTrims implements TrimInterface
{
    GT, EcoBoost, Mach1, GT500;

    private static final List<MustangTrims> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    public static final int SIZE = VALUES.size();
    public static final Random RAND = new Random();

    // An override of toString to properly set the value of the name vehicle dependent of the trim
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

    // This function returns a Random Trim based on this brand of car
    public static MustangTrims getRandTrim()
    {
        return VALUES.get(RAND.nextInt(SIZE));
    }
}
