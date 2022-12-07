package interfaceAdapters;

import useCase.GenerateUserHistory;
import useCase.GenerateUserHistoryOutputBoundary;
import entities.UserAccount;



public class UserHistoryPresenter implements GenerateUserHistoryOutputBoundary {
    /** Presenter for the User History. Presents the results from the GenerateUserHistory use case.
     * Each function returns a string of the statistics for the UI.
     * @return String of the specific statistic
     */
/**
 *
 @Override
    public String presenterTotalLikes(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return Integer.toString(generateHistory.getTotalLiked(user));
    }

    @Override
    public String presenterTotalBlocks(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return Integer.toString(generateHistory.getTotalBlocks(user));
    }

    @Override
    public String presenterTotalMatches(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return Integer.toString(generateHistory.getTotalMatches(user));
    }

    @Override
    public String presenterLikedAge(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return Integer.toString(generateHistory.getLikedAgeRange(user));
    }

    @Override
    public String presenterLikedCity(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return generateHistory.getLikedCity(user);
    }

    @Override
    public String presenterLikedCountry(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return generateHistory.getLikedCountry(user);
    }

    @Override
    public String presenterLikedGender(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return generateHistory.getLikedGender(user);
    }

    @Override
    public String presenterLikedInterest(UserAccount user){
        GenerateUserHistory generateHistory = new GenerateUserHistory();
        return generateHistory.getLikedInterest(user);
    }*/
}
