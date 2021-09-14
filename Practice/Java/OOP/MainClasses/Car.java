package MainClasses;

public class Car
{
    protected int year = 0;
    protected String carClass, name, manufacturer, drivetrain = "";
    protected Engine engine = null;

    public Car() {}

    @Override
    public String toString()
    {
        return (year + "" + manufacturer + "" + name
                + "\n" + carClass + "" + drivetrain + "" + engine.toString());
    }

    //region Getters
    protected String getCarClass() {
        return carClass;
    }

    protected String getName() {
        return name;
    }

    protected String getManufacturer() {
        return manufacturer;
    }

    protected String getDrivetrain() {
        return drivetrain;
    }

    protected String getEngine() {
        return engine.toString();
    }

    protected int getYear() {
        return year;
    }

    //endregion

    //region Setters

    protected void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    protected void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    protected void setEngine(Engine engine) {
        this.engine = engine;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    //endregion
}