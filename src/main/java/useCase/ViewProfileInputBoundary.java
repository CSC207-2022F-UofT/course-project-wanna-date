package useCase;

import entities.UserAccount;

import java.util.ArrayList;

/** InputBoundary for ViewProfile feature.
 */
public interface ViewProfileInputBoundary {

    ArrayList<String> searchInfo(String username);

    UserAccount searchUserAccount(String username);

}