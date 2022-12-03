package interfaceAdapters;

import entities.UserAccount;
import useCase.GenerateUserHistoryInputBoundary;
import useCase.GenerateUserHistory;

public class UserHistoryController implements GenerateUserHistoryInputBoundary{
    public String getUserHistoryController(UserAccount user, String stat) {
        GenerateUserHistoryInputBoundary generateHistory = new GenerateUserHistory();
        UserHistoryPresenter presenter = new UserHistoryPresenter();


        //String for each specific stat
        String specificStat = generateHistory.getCurrentUserStats(user, stat);

        if (specificStat == "totalLike"){
            return presenter.presenterTotalLikes(user); // Returns a String used in UI
        }
        else if (specificStat == "totalBlock") {
            return presenter.presenterTotalBlocks(user);
        }
        else if (specificStat == "totalMatch") {
            return presenter.presenterTotalMatches(user);
        }
        else if (specificStat == "likedAge") {
            return presenter.presenterLikedAge(user);
        }
        else if (specificStat == "likedCity") {
            return presenter.presenterLikedCity(user);
        }
        else if (specificStat == "likedCountry") {
            return presenter.presenterLikedCountry(user);
        }
        else if (specificStat == "likedGender") {
            return presenter.presenterLikedGender(user);
        }
        else if (specificStat == "likedInterest") {
            return presenter.presenterLikedInterest(user);
        }
        else {
            return "";
        }
     }
}

