package Menu;

import java.sql.SQLException;
import java.util.Scanner;

public abstract class PrintView {
    protected Scanner scn;
    protected String viewerType;
    protected PrintManager pm;

    public PrintView(String viewerType, Scanner scn)
    {
        this.viewerType = viewerType;
        this.scn = scn;
        this.pm = pm.getPM();
    }

    public String getViewerType()
    {
        return viewerType;
    }

    public abstract void printMenu() throws SQLException;
}
