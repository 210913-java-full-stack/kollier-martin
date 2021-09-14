package MainClasses;

import Enums.*;

public class Engine
{
    private int horsePower = 0;
    private EngineEnum engineType = null;
    private BoostEnum boostType = null;

    //base constructor
    public Engine(){}

    public Engine(BoostEnum boostType, EngineEnum engineType, int horsePower)
    {
        this.horsePower = horsePower;
    }

    public void setBoostType(BoostEnum boostType)
    {
        this.boostType = boostType;
    }

    public void setEngineType(EngineEnum engineType)
    {
        this.engineType = engineType;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower = horsePower;
    }

    @Override
    public String toString()
    {
        return (this.boostType.toString() + "" + this.engineType.toString() + ": " + horsePower);
    }
}
