package useCase;

import entities.UserAccount;

import java.util.ArrayList;

public interface ViewProfileInputBoundary {

    ArrayList<String> searchInfo(String username);

    UserAccount searchUserAccount(String username);

}