package entities;

import java.util.ArrayList;

public class UserHistory {

    //Array list of users liked
    private ArrayList<UserHistory> likedUsers;
    //Array list of users blocked
    private ArrayList<UserHistory> blockedUsers;
    //Array list of users messaged
    private ArrayList<UserHistory> messagedUsers;
    //Array list of words searched in the search bar
    private ArrayList<UserHistory> searchedWords;

    public UserHistory() {
        ArrayList<UserHistory> likedUsers = new ArrayList<UserHistory>();
        ArrayList<UserHistory> blockedUsers = new ArrayList<UserHistory>();
        ArrayList<UserHistory> messagedUsers = new ArrayList<UserHistory>();
        ArrayList<UserHistory> searchedWords = new ArrayList<UserHistory>();
    }

    //Get functions
    public ArrayList<UserHistory> getLikedUsers() {
        return this.likedUsers;
    }

    public ArrayList<UserHistory> getBlockedUsers() {
        return this.blockedUsers;
    }

    public ArrayList<UserHistory> getMessagedUsers() {
        return this.messagedUsers;
    }

    public ArrayList<UserHistory> getSearchedWords() {
        return this.searchedWords;
    }

    public void setLikedUsers(UserHistory username){
        likedUsers.add(username);
    }

    public void setBlockedUsers(UserHistory username){
        likedUsers.add(username);
    }

    public void setMessagedUsers(UserHistory username){
        likedUsers.add(username);
    }

    public void setSearchedWords(UserHistory searched){
        likedUsers.add(searched);
    }
}



