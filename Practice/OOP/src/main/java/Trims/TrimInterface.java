package Trims;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public interface TrimInteface
{
    // Base method for returning a random trim
    static Enum getRandTrim(){
        return null;
    }

    // VALUES is a cached list of the values given in this enumerator
    List<Enum> VALUES = null;

    // SIZE is a final integer value declaring how big the VALUES list is
    int SIZE = 0;

    // Final Random variable used in the fetching of the random trim
    Random RAND = null;
}
