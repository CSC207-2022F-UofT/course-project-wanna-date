package interface_adapters.account;

import frameworks_drivers.account.DataExport;

import java.io.IOException;

/** A Controller class that controls the Logout feature.
 * This class is called when a user logs out from the application.
 * */
public class LogoutController {

    public LogoutController() {}

    /** Function that helps in calling the controller DataExport class to write the Database of the application
     * to an outer CSV File.
     * */
    public void helpWriteDatabase() throws IOException {
        DataExport dataExport = new DataExport();
        dataExport.writeCSV();
    }
}
