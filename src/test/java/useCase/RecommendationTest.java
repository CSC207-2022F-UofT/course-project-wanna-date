package useCase;

import entities.UserAccount;
import frameworksDrivers.RecDataAccessor;
import interfaceAdapters.RecShowRecBoundary;
import interface_adapters.FakeRecPresenter;
import interface_adapters.FakeRecUI;
import org.junit.jupiter.api.Test;

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
    RecOutputBoundary recPresenter = new FakeRecPresenter();
    DatabaseManager someDatabase = DatabaseManager.getDatabaseManager();
    CurrUserManager someUserManager = CurrUserManager.getCurrUserManager();

    // Create generic users
    UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
            "ON", "TOR", "F", "H","Watching", "12356435");
    UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her",
            "CAN", "ON", "TOR", "F", "H","Music", "124564565");

    // TODO: figure out a way to do testing by means of the DatabaseManager.
    //  After consulting in office hours, I have figured out a way to test the Recommendation use case despite the
    //  singleton DataManager. I will write unit tests by use of mocking via Mockito and JUnit.
    //  However, I was unable to finish these tests since currently there are errors in the program which have
    //  to be fixed.
    //  TODO: add return values to methods I will test, because it won't matter since I don't use return anyway
    // Sources:
    // https://www.vogella.com/tutorials/Mockito/article.html
    // https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit

    @Test
    public void RecommendationTest7ValidUsers() {

        // TODO: redo this test
        // Create generic classes with mocking
        RecOutputBoundary recPresenter = new FakeRecPresenter();
        DatabaseManager someDatabase = mock(DatabaseManager.class);
        CurrUserManager someUserManager = mock(CurrUserManager.class);

        // what UC calls
        // DatabaseManager.getDatabaseManager()
        // this.databaseRef.getDatabase().getData()
        // CurrUserManager.getCurrUserManager()
        // singletonUserManager.getCurrUser();

        // Create generic users
        UserAccount user1 = new UserAccount("AL", "AML", 20, "her", "CAN",
                "ON", "TOR", "F", "H","Watching", "12356435");
        UserAccount user2 = new UserAccount("JSmith", "Jessica Smith", 20, "her",
                "CAN", "ON", "TOR", "F", "H","Music", "124564565");

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  there are at least 7 users total
        //  FakeRecUI and FakeRecPresenter should implement showRecBoundary but should also do nothing
        // Create a use case object
        RecInputBoundary recUseCase = new Recommendation(recPresenter);
        HashMap<String, UserAccount> testData = new HashMap<>();
        testData.put("AL", user1);
        testData.put("JSmith", user2);

        when(someUserManager.getCurrUser()).thenReturn(user1);
        //when(someDatabase.getDatabase()).thenReturn(null);
        RecommendedProfiles results = recUseCase.makeRecommendations();
        System.out.println(results);
        // TODO next steps: delete the files which cause errors + update DataExport file path so that
        //  I can run tests of my code for the video
      // block of coverage
        // verify?

    }

    @Test
    public void RecommendationTestLessValidUsers() {

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  there are less than 7 users total, meaning that the pool of options will be less
    }

    @Test
    public void RecommendationTestBlockedUsers() {

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  at least one different user is blocked such that they would not get recommended
    }

    @Test
    public void RecommendationTestPerfectMatch() {

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  at least one different user would have a 100% compatibility with the current user
    }
}