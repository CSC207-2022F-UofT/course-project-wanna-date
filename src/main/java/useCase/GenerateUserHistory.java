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

    // Return String list of liked usernames
    public String[] likedUsernames(UserAccount user) {
        String[] likedUsernames = new String[user.getLikedUsers().size()];

        ArrayList<UserAccount> liked = user.getLikedUsers();

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            likedUsernames[i] = liked.get(i).getUsername();
        }

        return likedUsernames;
    }

    // Return String list of blocked usernames
    public String[] blockedUsernames(UserAccount user) {
        String[] blockedUsernames = new String[user.getBlockedUsers().size()];

        ArrayList<UserAccount> blocked = user.getBlockedUsers();

        for (int i = 0; i < user.getBlockedUsers().size(); i++) {
            blockedUsernames[i] = blocked.get(i).getUsername();
        }

        return blockedUsernames;
    }

    // Return UserAccount ArrayList of matched users
    public ArrayList<UserAccount> matchedUsers(UserAccount user) {

        UserAccount[] likedUsers = user.getLikedUsers().toArray(new UserAccount[0]);
        UserAccount[] likedByUsers = user.getLikedByUsers().toArray(new UserAccount[0]);

        ArrayList<UserAccount> matchedUsersList = new ArrayList<>();

        for (int i = 0; i < likedUsers.length; i++)
        {
            for (int k = 0; k < likedByUsers.length; k++)
            {
                if(likedUsers[i] == (likedByUsers[k]))
                {
                    matchedUsersList.add(likedUsers[i]);
                }
            }
        }
        return matchedUsersList;
    }

    // Return String list of matched usernames
    public String[] matchedUsernames(UserAccount user){

        String[] matchedUsernames = new String[matchedUsers(user).size()];

        ArrayList<UserAccount> matched = matchedUsers(user);

        for (int i = 0; i < matchedUsers(user).size(); i++) {
            matchedUsernames[i] = matched.get(i).getUsername();
        }

        return matchedUsernames;
    }

    // Most common age among the liked users
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
         return commonAge;
    }

    // Most common city that the liked users are from
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

    // Most common country that the liked users are from
    public String getLikedCountry(UserAccount user){
        String commonLocation = "";
        String[] countries = new String[user.getLikedUsers().size()];

        for (int i = 0; i < user.getLikedUsers().size(); i++) {
            countries[i] = user.getLikedUsers().get(i).getLocation().get("country").toString();
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

    // The gender that the user most often likes
    // 'M': male
    // 'F': female
    // 'N': non-binary
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
                        if (likedType[i] == (likedType[k])) {
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

    // The most common interest that the liked users share
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

    // Get total number of likes the user has made
    public int getTotalLiked(UserAccount user){
        return user.getLikedUsers().size();
    }

    // Get total number of blocks the user has mde
    public int getTotalBlocks(UserAccount user){
        return user.getBlockedUsers().size();
    }

    // Get total number of matches the user has
    public int getTotalMatches(UserAccount user){
        return matchedUsers(user).size();
    }
}