package use_case.account;

import java.util.ArrayList;

/** OutputBoundary for ViewProfile feature.
 */
public interface ViewProfileOutputBoundary {

    void getInfo(ArrayList<String> info);
}