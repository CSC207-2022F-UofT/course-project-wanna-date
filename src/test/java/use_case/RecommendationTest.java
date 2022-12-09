package use_case;

import entities.account.UserAccount;
import interface_adapters.FakeRecPresenter;
import interface_adapters.FakeRecUI;
import interface_adapters.recommendation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.account.*;
import use_case.recommendation.*;

import java.util.HashMap;
import java.util.Objects;

import static org.mockito.Mockito.*;

// To the developer:
// When running these tests, you may get a message akin to:
// This does not appear to be a bug at all despite the red text. Please refer to
// https://youtrack.jetbrains.com/issue/IDEA-260211 for documentation on this oddity of Gradle.
// The tests all pass, though!

class RecommendationTest {

    // Create generic classes
    RecShowRecBoundary fakeRecUI = new FakeRecUI();
    RecOutputBoundary recPresenter = new FakeRecPresenter();

    // Create generic users
    UserAccount user1 = new UserAccount("AL", "AML", 20, "She/Her", "CAN",
            "ON", "TOR", "F", "B", "Watching", "12356435");
    UserAccount user1clone = new UserAccount("AL", "AML", 20, "She/Her", "CAN",
            "ON", "TOR", "F", "B", "Watching", "12356435");
    UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "She/Her",
            "CAN", "ON", "TOR", "F", "B","Music", "124564565");
    UserAccount user2clone = new UserAccount("JSmith", "Jessica Smith", 20, "She/Her",
            "CAN", "ON", "TOR", "F", "B","Music", "124564565");
    UserAccount user3 = new UserAccount("MSmith", "Macy Smith", 20, "She/Her",
            "CAN", "ON", "TOR", "N", "B","Travelling", "124564565");
    UserAccount user4 = new UserAccount("SSol", "Shady Sol", 20, "He/Him",
            "CAN", "ON", "TOR", "M", "B","Music", "124564565");
    UserAccount user5 = new UserAccount("LoveIsLove", "Layla Lovelace", 20, "She/Her",
            "CAN", "ON", "TOR", "F", "L","Culinary", "124564565");
    UserAccount user6 = new UserAccount("AristA", "Arist Bravo", 20, "He/Him",
            "CAN", "ON", "TOR", "M", "H","Watching", "124564565");
    UserAccount user6clone = new UserAccount("AristA", "Arist Bravo", 20, "He/Him",
            "CAN", "ON", "TOR", "M", "H","Watching", "124564565");
    UserAccount user7 = new UserAccount("THolt", "Tai Holt", 20, "He/Him",
            "CAN", "ON", "TOR", "M", "H","Travelling", "124564565");

    @Test
    public void RecommendationTest7ValidUsers() {

        // Simulate the controller being run with typical recommendations for a profile; assume that
        // there are at least 7 users total; test that we get 5 users randomly

        // Create a use case object and needed items for it
        HashMap<String, UserAccount> testData = new HashMap<>();
        testData.put("AL", user1);
        testData.put("JSmith", user2);
        testData.put("MSmith", user3);
        testData.put("SSol", user4);
        testData.put("LoveIsLove", user5);
        testData.put("AristA", user6);
        testData.put("THolt", user7);

        RecDataGetter fakeDataGetter = new TestRecDataGetter(user1, testData);
        RecInputBoundary recUseCase = new Recommendation(recPresenter, fakeDataGetter);

        // Get results
        RecommendedProfiles actual = recUseCase.makeRecommendations();

        // Assert on results
        Assertions.assertEquals(user1.getUsername(), actual.getRecProfileUser());
        Assertions.assertEquals(5, actual.getRecUserAcc().size());
    }

    @Test
    public void RecommendationTestLessValidUsers() {

        // Simulate the controller being run with typical recommendations for a profile; assume that
        // there are less than 6 users total, meaning that the pool of options will be less and we can
        // test ordering

        // Create a use case object and needed items for it
        HashMap<String, UserAccount> testData = new HashMap<>();
        testData.put("AL", user1);
        testData.put("JSmith", user2);
        testData.put("MSmith", user3);
        testData.put("SSol", user4);
        testData.put("AristA", user6);

        RecDataGetter fakeDataGetter = new TestRecDataGetter(user6, testData);
        RecInputBoundary recUseCase = new Recommendation(recPresenter, fakeDataGetter);

        // Get results
        RecommendedProfiles actual = recUseCase.makeRecommendations();

        // Assert on results
        Assertions.assertEquals(user6.getUsername(), actual.getRecProfileUser());
        Assertions.assertEquals(2, actual.getRecUserAcc().size());
        Assertions.assertEquals("AL", actual.getRecUserAcc().get(0));
        Assertions.assertEquals("JSmith", actual.getRecUserAcc().get(1));
    }

    @Test
    public void RecommendationTestBlockedUsers() {

        // Simulate the controller being run with typical recommendations for a profile; assume that
        // there are less than 6 users total, meaning that the pool of options will be less and we can
        // test ordering

        // Create a use case object and needed items for it
        user4.setBlockedUsers(user6);
        HashMap<String, UserAccount> testData = new HashMap<>();
        testData.put("AL", user1);
        testData.put("JSmith", user2clone);
        testData.put("MSmith", user3);
        testData.put("SSol", user4);
        testData.put("AristA", user6);

        RecDataGetter fakeDataGetter = new TestRecDataGetter(user6, testData);
        RecInputBoundary recUseCase = new Recommendation(recPresenter, fakeDataGetter);

        // Get results
        RecommendedProfiles actual = recUseCase.makeRecommendations();

        // Assert on results
        Assertions.assertEquals(user6.getUsername(), actual.getRecProfileUser());
        Assertions.assertEquals(2, actual.getRecUserAcc().size());
        Assertions.assertEquals("AL", actual.getRecUserAcc().get(0));
    }

    @Test
    public void RecommendationTestPerfectMatch() {

        // Simulate the controller being run with typical recommendations for a profile; assume that
        // at least one different user would have a 100% compatibility with the current user
        // Simulate the controller being run with typical recommendations for a profile; assume that
        // there are less than 6 users total, meaning that the pool of options will be less and we can
        // test ordering

        // Create a use case object and needed items for it
        user4.setBlockedUsers(user6);
        user1.setLikedByUsers(user1clone);
        HashMap<String, UserAccount> testData = new HashMap<>();
        testData.put("AL", user1clone);
        testData.put("JSmith", user2clone);
        testData.put("MSmith", user3);
        testData.put("SSol", user4);
        testData.put("AristA", user6clone);

        RecDataGetter fakeDataGetter = new TestRecDataGetter(user6clone, testData);
        RecInputBoundary recUseCase = new Recommendation(recPresenter, fakeDataGetter);

        // Get results
        RecommendedProfiles actual = recUseCase.makeRecommendations();

        // Assert on results
        Assertions.assertEquals(user6clone.getUsername(), actual.getRecProfileUser());
        Assertions.assertEquals(2, actual.getRecUserAcc().size());
        Assertions.assertEquals("AL", actual.getRecUserAcc().get(0));
    }
}