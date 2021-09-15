package Enums;

public enum EngineSpecs
{
    I4, I6, V4, V6, V8, V10, V12, NA, Supercharged, TwinCharged, TurboCharged;

    @Override
    public String toString()
    {
        String name = "";
        switch (this)
        {
            case NA:
                name = ("Naturally Aspirated");
                break;
            case Supercharged:
                name = ("Supercharged");
                break;
            case TwinCharged:
                name = ("Twin-Charged");
                break;
            case TurboCharged:
                name = ("Turbo-Charged");
                break;
        }

        return name;
    }
}
