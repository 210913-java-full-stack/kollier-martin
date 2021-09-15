package Cars;

import MainClasses.*;
import Enums.*;
import Trims.MustangTrims;

public class Mustang extends Car
{
    public Mustang(MustangTrims trim)
    {
        setYear(2022);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Ford.toString());
        setName("Mustang");

        switch (trim)
        {
            case EcoBoost:
                setEngine(new Engine(EngineSpecs.TurboCharged, EngineSpecs.V4, 310));
                setTrim(trim);
                break;
            case GT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 460));
                setTrim(trim);
                break;
            case Mach1:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 480));
                setTrim(trim);
                break;
            case GT500:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 760));
                setTrim(trim);
                break;
        }
    }
}
