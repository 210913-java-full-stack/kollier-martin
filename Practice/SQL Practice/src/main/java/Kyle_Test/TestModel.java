/*
 * Kyle's code to make a test Model for an object
 *
 */

package Kyle_Test;

public class TestModel
{
    private int id = 0;
    private String name = "";
    private String string = "";

    public TestModel()
    {

    }

    public TestModel(int i, String name, String string) {
        this.id = i;
        this.name = name;
        this.string = string;
    }

    public int getID() {
        return id;
    }

    public void setI(int i) {
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString()
    {
        return (this.id + " ~ " + this.name + " ~ " + this.string);
    }
}
