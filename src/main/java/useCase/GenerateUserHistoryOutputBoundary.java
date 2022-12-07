package useCase;

import entities.UserAccount;

public interface GenerateUserHistoryOutputBoundary {
    /** GenerateUserHistory Output Boundary.
     * Create functions
     * @return
     */


    default String presenterTotalLikes(UserAccount user){
        return null;
    }

    default String presenterTotalBlocks(UserAccount user){
        return null;
    }

    default String presenterTotalMatches(UserAccount user){
        return null;
    }

    default String presenterLikedAge(UserAccount user){
        return null;
    }

    default String presenterLikedCity(UserAccount user){
        return null;
    }

    default String presenterLikedCountry(UserAccount user){
        return null;
    }

    default String presenterLikedGender(UserAccount user){
        return null;
    }

    default String presenterLikedInterest(UserAccount user){
        return null;
    }

}