/**
 * Interface that establishes the method and variable that will be used to randomly decide a trim and store said value into the variable
 *
 * @author Kollier Martin
 * @version 9/14/2021
 */

package Cars;

import MainClasses.*;
import Trims.EvoTrims;
import Enums.*;

public class Evo extends Car implements VehicleInterface
{
    EvoTrims trim;

    public Evo()
    {
        setYear(2015);
        setCarClass("4D");
        setDrivetrain("AWD");
        setManufacturer(Manufacturers.Mitsubishi.toString());
        setName("Lancer Evolution");
        randomTrim();
    }

    public Evo(EvoTrims trim)
    {
        setYear(2015);
        setCarClass("4D");
        setDrivetrain("AWD");
        setManufacturer(Manufacturers.Mitsubishi.toString());
        setName("Lancer Evolution");

        switch (trim)
        {
            case MR:
            case GSR:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 291));
                setTrim(trim);
                break;
            case Final:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 303));
                setTrim(trim);
                break;
        }
    }

    @Override
    public void randomTrim()
    {
        trim = EvoTrims.getRandTrim();

        switch (trim)
        {
            case MR:
            case GSR:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 291));
                setTrim(trim);
                break;
            case Final:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 303));
                setTrim(trim);
                break;
        }
    }
}
