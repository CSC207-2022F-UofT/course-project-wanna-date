package interfaceAdapters;

import frameworksDrivers.DataExport;

import java.io.IOException;

public class LogoutController {

    public LogoutController() {}

    public void helpWriteDatabase() throws IOException {
        DataExport dataExport = new DataExport();
        dataExport.write_csv();

    }
}
