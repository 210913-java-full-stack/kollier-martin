package Cars;

import MainClasses.*;
import Trims.ChargerTrims;
import Enums.*;

public class Charger extends Car
{
    public Charger(ChargerTrims trim)
    {
        setYear(2022);
        setCarClass("4D");
        setDrivetrain("RWD");
        setManufacturer(Manufacturers.Dodge.toString());
        setName("Charger");

        switch (trim)
        {
            case SXT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 292));
                setTrim(trim);
                break;
            case SXTAWD:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V6, 300));
                setTrim(trim); setDrivetrain("AWD");
                break;
            case RT:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 370));
                setTrim(trim);
                break;
            case ScatPack:
                setEngine(new Engine(EngineSpecs.NA, EngineSpecs.V8, 485));
                setTrim(trim);
                break;
            case Hellcat:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 717));
                setTrim(trim);
                break;
            case HellcatRedeye:
                setEngine(new Engine(EngineSpecs.Supercharged, EngineSpecs.V8, 797));
                setTrim(trim);
                break;
        }
    }
}

