package Cars;

import MainClasses.*;
import Trims.*;
import Enums.*;

public class Mustang extends Car
{
    public Mustang(MustangTrims trim)
    {
        setYear(2021);
        setCarClass("Coupe");
        setDrivetrain("RWD");
        setManufacturer("Ford");
        setName("Mustang");

        switch (trim)
        {
            case EcoBoost:
                setEngine(new Engine(BoostEnum.TurboCharged, EngineEnum.V4, 310));
                break;
            case GT:
                setEngine(new Engine(BoostEnum.NaturallyAspirated, EngineEnum.V8, 460));
                break;
            case Mach1:
                setEngine(new Engine(BoostEnum.NaturallyAspirated, EngineEnum.V8, 480));
                break;
            case GT500:
                setEngine(new Engine(BoostEnum.Supercharged, EngineEnum.V8, 707));
                break;
        }
    }
}
