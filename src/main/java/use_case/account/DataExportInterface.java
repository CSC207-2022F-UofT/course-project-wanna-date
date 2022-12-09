package use_case.account;

/** InputBoundary for DataExport.
 *  Function with no implementation that will be overwritten in DatabaseManager class.
 */
public interface DataExportInterface {
    Object[][] writeDatabase();
}
