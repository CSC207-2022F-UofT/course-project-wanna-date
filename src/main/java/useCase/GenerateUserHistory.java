package useCase;
import entities.UserHistory;
import entities.UserAccount;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateUserHistory implements GenerateUserHistoryInputBoundary {

    public void viewStats(GenerateUserHistoryOutputBoundary viewUserHistory){
        viewUserHistory.presenterUserHistory();
    }

    // Return liked users
    public ArrayList likedUsers(UserHistory user){
        return user.getLikedUsers();
    }

    // Return blocked users
    public ArrayList blockedUsers(UserHistory user){
        return user.getBlockedUsers();
    }

    // Use the age data of the people the user liked to find the most common age
    // that the user would like
    public int getLikedAgeRange(UserAccount user){
        int[] ages = new int[user.get_liked_users().size()];

        for (int i = 0; i < user.get_liked_users().size(); i++) {
            ages[i] = user.get_age();
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

    // Use the location data of the people the user liked to find the most common city that
    // the liked users are from. The location is mapped as country, province, and city.
    public String getLikedLocation(UserAccount user){
        String commonLocation = "";
        String[] cities = new String[user.get_liked_users().size()];

        for (int i = 0; i < user.get_liked_users().size(); i++) {
            cities[i] = user.get_location().get("city").toString();
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

    // Use user history data to provide statistics on what kind of people the user likes by looking
    // at the gender of the users that the user liked.
    // The gender identified by user.
    // 'M': male
    // 'F': female
    // 'N': non-binary
    public String getLikedType(UserAccount user) {
        String[] userCategories = new String[]{"Likes male users", "Likes female users",
                "Likes non-binary users"};

        String commonLikedType = "";
        int commonLikedTypeInt = 0;

        String [] likedType = new String[user.get_liked_users().size()];

        for (int i = 0; i < user.get_liked_users().size(); i++) {
            likedType[i] = user.get_gender();
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

        if (commonLikedType == "M") {
            commonLikedTypeInt = 0;
        }
        else if (commonLikedType == "F") {
            commonLikedTypeInt = 1;
        }
        else if (commonLikedType == "N") {
            commonLikedTypeInt = 2;
        }

        return userCategories[commonLikedTypeInt];
    }

    // Get total number of likes the user has made
    public int getTotalLiked(UserHistory user){
        return user.getLikedUsers().size();
    }

    // Get total number of blocks the user has ade
    public int getTotalBlocks(UserHistory user){
        return user.getBlockedUsers().size();
    }

    //Get total number of users that the user has sent a message to
    public int getTotalUsersMessaged(UserHistory user){
        return user.getMessagedUsers().size();
    }
}