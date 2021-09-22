/*
 *
 *
 */

package DAOs;

import java.sql.SQLException;
import java.util.List;

public interface BankCrud {
    // create
    //public void save(ToDoItem row) throws SQLException;

    // read
        // query data from database, fill empty model object
    //public ToDoItem getItemByID(int ID) throws SQLException;
    //public List<ToDoItem> getAllItems();

    // update
        // save() will be used for updates

    // delete
        // remove by ID
    public void deleteByID();
}
