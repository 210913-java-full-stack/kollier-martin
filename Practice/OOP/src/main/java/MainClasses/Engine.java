package MainClasses;

import Enums.*;

public class Engine
{
    private int horsePower = 0;
    private EngineSpecs engineType, boostType = null;

    //base constructor
    public Engine(){}

    public Engine(EngineSpecs boostType, EngineSpecs engineType, int horsePower)
    {
        this.boostType = boostType;
        this.engineType = engineType;
        this.horsePower = horsePower;
    }

    public void setBoostType(EngineSpecs boostType)
    {
        this.boostType = boostType;
    }

    public void setEngineType(EngineSpecs engineType)
    {
        this.engineType = engineType;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    public EngineSpecs getBoostType()
    {
        return this.boostType;
    }

    public EngineSpecs getEngineType()
    {
        return this.engineType;
    }

    @Override
    public String toString()
    {
        return boostType + " " + engineType + ": " + horsePower;
    }
}
