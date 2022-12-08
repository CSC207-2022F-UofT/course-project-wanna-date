package useCase;

import entities.UserAccount;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * GenerateUserHistory retrieves different statistics regarding the user's liked and blocked users.
 */
public class GenerateUserHistory implements GenerateUserHistoryInputBoundary {

    // Presenter
    public void viewStats(GenerateUserHistoryOutputBoundary viewUserHistory){
        viewUserHistory.presenterUserHistory();
    }

    /**
     * Function that returns a String list of liked usernames
     * @param user UserAccount of current user
     * @return return a String array of the usernames of the accounts liked
     */
    public String[] likedUsernames(UserAccount user) {
        String[] likedUsernames = new String[user.getLikedUsers().size()];

        ArrayList<UserAccount> liked = user.getLikedUsers();

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            likedUsernames[i] = liked.get(i).getUsername();
        }

        return likedUsernames;
    }

    /**
     * Function that returns String list of blocked usernames
     * @param user UserAccount of current user
     * @return return a String array of the usernames of the accounts blocked
     */
    public String[] blockedUsernames(UserAccount user) {
        String[] blockedUsernames = new String[user.getBlockedUsers().size()];

        ArrayList<UserAccount> blocked = user.getBlockedUsers();

        for (int i = 0; i < user.getBlockedUsers().size(); i++) {
            blockedUsernames[i] = blocked.get(i).getUsername();
        }

        return blockedUsernames;
    }

    /**
     * Function that returns array of matches users
     * @param user UserAccount of current user
     * @return return an ArrayList of the matched UserAccount users
     */
    public ArrayList<UserAccount> matchedUsers(UserAccount user) {

        UserAccount[] likedUsers = user.getLikedUsers().toArray(new UserAccount[0]);
        UserAccount[] likedByUsers = user.getLikedByUsers().toArray(new UserAccount[0]);

        ArrayList<UserAccount> matchedUsersList = new ArrayList<>();

        for (UserAccount likedUser : likedUsers) {
            for (UserAccount likedByUser : likedByUsers) {
                if (likedUser == likedByUser) {
                    matchedUsersList.add(likedUser);
                }
            }
        }
        return matchedUsersList;
    }

    /**
     * Function that returns String list of matched usernames
     * @param user UserAccount of current user
     * @return return a String array of the usernames of the accounts matched
     */
    public String[] matchedUsernames(UserAccount user){

        String[] matchedUsernames = new String[matchedUsers(user).size()];

        ArrayList<UserAccount> matched = matchedUsers(user);

        for (int i = 0; i < matchedUsers(user).size(); i++) {
            matchedUsernames[i] = matched.get(i).getUsername();
        }

        return matchedUsernames;
    }

    /**
     * Function that returns the most common age among the liked users
     * @param user UserAccount of current user
     * @return return an int of the most common age
     */
    public int getLikedAgeRange(UserAccount user){
        int[] ages = new int[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            ages[i] = user.getLikedUsers().get(i).getAge();
        }

        int commonAge = Integer.MIN_VALUE, maxCount = 1, count = 1;

        //Put array in ascending order
        Arrays.sort(ages);

        for(int i = 1; i < ages.length; i++) {

            if(ages[i] == ages[i-1])
                count++;

            if(ages[i] != ages[i - 1] || i == ages.length - 1) {
                if(count > maxCount){

                    //Update if greater
                    maxCount = count;
                    commonAge = ages[i - 1];
                }
                count = 1;
            }
        }
        //Return most common Age

        if (commonAge < 0) {
            return 0;
        }
        else {
            return commonAge;
        }
    }

    /**
     * Function that returns the most common city among the liked users
     * @param user UserAccount of current user
     * @return return a String of the most common city
     */
    public String getLikedCity(UserAccount user){
        String commonLocation = "";
        String[] cities = new String[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            cities[i] = user.getLikedUsers().get(i).getLocation().get("city");
        }

        boolean[] alreadySeen = new boolean[cities.length];

        int resultCount = 0;
        for (int i = 0; i < cities.length; i++) {
            if (!alreadySeen[i]) {
                alreadySeen[i] = true;
                int count = 1;
                for (int k = i + 1; k < cities.length; k++) {
                    if (!alreadySeen[k]) {
                        if (cities[i].equals(cities[k])) {
                            alreadySeen[k] = true;
                            count++;
                        }
                    }
                }
                if (count > resultCount) {
                    resultCount = count;
                    commonLocation = cities[i];
                }
            }
        }
        return commonLocation;
    }

    /**
     * Function that returns the most common country among the liked users
     * @param user UserAccount of current user
     * @return return a String of the most common country
     */
    public String getLikedCountry(UserAccount user){
        String commonLocation = "";
        String[] countries = new String[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            countries[i] = user.getLikedUsers().get(i).getLocation().get("country");
        }

        boolean[] alreadySeen = new boolean[countries.length];

        int resultCount = 0;
        for (int i = 0; i < countries.length; i++) {
            if (!alreadySeen[i]) {
                alreadySeen[i] = true;
                int count = 1;
                for (int k = i + 1; k < countries.length; k++) {
                    if (!alreadySeen[k]) {
                        if (countries[i].equals(countries[k])) {
                            alreadySeen[k] = true;
                            count++;
                        }
                    }
                }
                if (count > resultCount) {
                    resultCount = count;
                    commonLocation = countries[i];
                }
            }
        }
        return commonLocation;
    }

    /**
     * Function that returns the most common gender among the liked users (M: male, F: female, N: non-binary)
     * @param user UserAccount of current user
     * @return return a String of the most common gender
     */
    public String getLikedGender(UserAccount user) {

        String commonLikedType = "";

        String [] likedType = new String[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            likedType[i] = user.getLikedUsers().get(i).getGender();
        }

        boolean[] alreadySeen = new boolean[likedType.length];

        int resultCount = 0;
        for (int i = 0; i < likedType.length; i++) {
            if (!alreadySeen[i]) {
                alreadySeen[i] = true;
                int count = 1;
                for (int k = i + 1; k < likedType.length; k++) {
                    if (!alreadySeen[k]) {
                        if (likedType[i].equals(likedType[k])) {
                            alreadySeen[k] = true;
                            count++;
                        }
                    }
                }
                if (count > resultCount) {
                    resultCount = count;
                    commonLikedType = likedType[i];
                }
            }
        }
        return commonLikedType;
    }

    /**
     * Function that returns the most common shared interest among the liked users
     * @param user UserAccount of current user
     * @return return a String of the most common interest
     */
    public String getLikedInterest(UserAccount user){
        String commonInterest = "";
        String[] interests = new String[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            interests[i] = user.getLikedUsers().get(i).getInterest();
        }

        boolean[] alreadySeen = new boolean[interests.length];

        int resultCount = 0;
        for (int i = 0; i < interests.length; i++) {
            if (!alreadySeen[i]) {
                alreadySeen[i] = true;
                int count = 1;
                for (int k = i + 1; k < interests.length; k++) {
                    if (!alreadySeen[k]) {
                        if (interests[i].equals(interests[k])) {
                            alreadySeen[k] = true;
                            count++;
                        }
                    }
                }
                if (count > resultCount) {
                    resultCount = count;
                    commonInterest = interests[i];
                }
            }
        }
        return commonInterest;
    }

    /**
     * Function that returns the number of liked accounts a user has
     * @param user UserAccount of current user
     * @return return an int of the total number of accounts that the user liked
     */
    public int getTotalLiked(UserAccount user){
        return user.getLikedUsers().size();
    }

    /**
     * Function that returns the number of blocked accounts a user has
     * @param user UserAccount of current user
     * @return return an int of the total number of accounts that the user blocked
     */
    public int getTotalBlocks(UserAccount user){
        return user.getBlockedUsers().size();
    }

    /**
     * Function that returns the number of matched accounts a user has
     * @param user UserAccount of current user
     * @return return an int of the total number of accounts that the user matched with
     */
    public int getTotalMatches(UserAccount user){
        return matchedUsers(user).size();
    }


}
