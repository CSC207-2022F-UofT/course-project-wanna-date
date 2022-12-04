package useCase;

import UI.RecBtnManager;
import frameworksDrivers.RecDataAccessor;
import interfaceAdapters.RecController;
import interfaceAdapters.RecPresenter;
import interfaceAdapters.RecShowRecBoundary;
import org.junit.jupiter.api.Test;
// import static org.mockito.Mockito.*; // TODO resolve

class RecommendationTest {

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

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  there are at least 7 users total
        //  FakeRecUI and FakeRecPresenter should implement showRecBoundary but should also do nothing
//        RecShowRecBoundary recBtnManager = new FakeRecUI();
//        RecOutputBoundary recPresenter = new FakeRecPresenter(recBtnManager);
//        RecDataAccessInterface recDataAccess = new RecDataAccessor();
//        RecInputBoundary recUseCase = new Recommendation(recPresenter, recDataAccess);
//
//        when(recUseCase.MakeRecommendations()).thenReturn(true); // TODO update syntax
//      // block of coverage
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