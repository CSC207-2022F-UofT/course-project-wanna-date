package useCase;

import entities.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

/**
 * Unit tests for the GenerateUserHistory use case.
 */
public class GenerateUserHistoryTest {

    // Fake users for testing purposes
    UserAccount user1 = new UserAccount("johnd", "John Doe", 20, "her", "USA",
            "ILL", "CHI", "M", "H","Watching", "123");
    UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her", "CAN",
            "ON", "TOR", "F", "G","Music", "124");
    UserAccount user3 = new UserAccount("janed", "Jane Doe", 18, "her", "CAN",
            "ON", "TOR", "F", "H","Music", "124");
    UserAccount user4 = new UserAccount("jenndoe", "Jennifer Doe", 18, "her", "CAN",
            "ON", "OTT", "F", "H","Watching", "124");

    // Test if likedUsers returns a String list of liked users
    @Test
    public void TestLikedUsernames(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);

        String[] userLikedTest = testHistory.likedUsernames(user1);
        String[] userLikedExpected = {"JSmith", "janed"};

        Assertions.assertArrayEquals(userLikedExpected,userLikedTest);
    }

    // Test if blockedUsers returns a String list of blocked users
    @Test
    public void TestBlockedUsernames(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setBlockedUsers(user2);
        user1.setBlockedUsers(user4);

        String[] userBlockedTest = testHistory.blockedUsernames(user1);
        String[] userBlockedExpected = {"JSmith", "jenndoe"};

        Assertions.assertArrayEquals(userBlockedExpected,userBlockedTest);
    }

    // Test if matchedUsers returns a UserAccount ArrayList of matched users
    @Test
    public void TestMatchedUsers(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedByUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedByUsers(user3);
        user1.setLikedUsers(user4);

        ArrayList<UserAccount> userBlockedTest = testHistory.matchedUsers(user1);
        ArrayList<UserAccount> userBlockedExpected = new ArrayList<>(){};
        userBlockedExpected.add(user2);
        userBlockedExpected.add(user3);

        Assertions.assertEquals(userBlockedExpected,userBlockedTest);
    }

    // Test if matchedUsernames returns a String list of matched usernames
    @Test
    public void TestMatchedUsernames(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedByUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedByUsers(user3);
        user1.setLikedUsers(user4);

        String[] userMatchedTest = testHistory.matchedUsernames(user1);
        String[] userMatchedExpected = {"JSmith", "janed"};

        Assertions.assertArrayEquals(userMatchedExpected,userMatchedTest);
    }

    // Test if getLikedAgeRange returns the most common age among the liked users
    @Test
    public void TestGetLikedAgeRange(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        int userAgeTest = testHistory.getLikedAgeRange(user1);
        int userAgeExpected = 18;

        Assertions.assertEquals(userAgeExpected, userAgeTest);
    }

    // Test if getLikedCity returns the most common city that the liked users are from
    @Test
    public void TestGetLikedCity(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        String userCityTest = testHistory.getLikedCity(user1);
        String userCityExpected = "TOR";

        Assertions.assertEquals(userCityExpected, userCityTest);
    }

    // Test if getLikedCountry returns the most common country that the liked users are from
    @Test
    public void TestGetLikedCountry(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        String userCountryTest = testHistory.getLikedCountry(user1);
        String userCountryExpected = "CAN";

        Assertions.assertEquals(userCountryExpected, userCountryTest);
    }

    // Test if getLikedGender returns the gender that the user most often likes
    @Test
    public void TestGetLikedGender(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        String userGenderTest = testHistory.getLikedGender(user1);
        String userGenderExpected = "F";

        Assertions.assertEquals(userGenderExpected, userGenderTest);
    }

    // Test if getLikedInterest returns the most common interest shared among the users liked
    @Test
    public void TestGetLikedInterest(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        String userInterestTest = testHistory.getLikedInterest(user1);
        String userInterestExpected = "Music";

        Assertions.assertEquals(userInterestExpected, userInterestTest);
    }

    // Test if getTotalLiked returns the total number of accounts the user liked
    @Test
    public void TestGetTotalLiked(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedUsers(user4);

        int userTotalLikedTest = testHistory.getTotalLiked(user1);
        int userTotalLikedExpected = 3;

        Assertions.assertEquals(userTotalLikedExpected, userTotalLikedTest);
    }

    // Test if getTotalBlocks returns the total number of accounts the user blocked
    @Test
    public void TestGetTotalBlocks(){
        GenerateUserHistory testHistory = new GenerateUserHistory();

        user1.setBlockedUsers(user2);
        user1.setBlockedUsers(user3);

        int userTotalBlocksTest = testHistory.getTotalBlocks(user1);
        int userTotalBlocksExpected = 2;

        Assertions.assertEquals(userTotalBlocksExpected, userTotalBlocksTest);
    }

    // Test if getTotalMatches returns the total number of matches the user has
    @Test
    public void TestGetTotalMatches(){
        GenerateUserHistory testHistory = new GenerateUserHistory();
        user1.setLikedUsers(user2);
        user1.setLikedByUsers(user2);
        user1.setLikedUsers(user3);
        user1.setLikedByUsers(user3);
        user1.setLikedUsers(user4);
        user1.setLikedByUsers(user4);

        int userTotalMatchesTest = testHistory.getTotalMatches(user1);
        int userTotalMatchesExpected = 3;

        Assertions.assertEquals(userTotalMatchesExpected, userTotalMatchesTest);
    }
}
