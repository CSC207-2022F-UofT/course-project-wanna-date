package use_case.account;

import entities.UserAccount;

import java.util.ArrayList;

/** InputBoundary for ViewProfile feature.
 */
public interface ViewProfileInputBoundary {

    ArrayList<String> searchInfo(String username, ViewProfileOutputBoundary viewProfileOutputBoundary);

    UserAccount searchUserAccount(String username);

}