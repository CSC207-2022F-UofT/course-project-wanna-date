package UseCase;

import org.junit.jupiter.api.Test;

class RecommendationTest {

    // TODO: figure out a way to do testing by means of the DatabaseManager.
    //  After conferencing in office hours, the problem was that because our implementations
    //  require use of the DatabaseManager, it is harder to create a "dummy" version of the
    //  data persistence layer for testing. I will have to talk to Lovina about this but will write tests
    //  later on.

    @Test
    public void RecommendationTest7ValidUsers() {

        // TODO: simulate the controller being run with typical recommendations for a profile; assume that
        //  there are at least 7 users total
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