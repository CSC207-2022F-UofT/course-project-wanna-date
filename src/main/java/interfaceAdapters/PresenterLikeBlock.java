package interfaceAdapters;
import useCase.RetrieveLikeOutputBoundary;
import useCase.RetrieveBlockOutputBoundary;

public class PresenterLikeBlock implements RetrieveBlockOutputBoundary, RetrieveLikeOutputBoundary{
    /** Presenter for both Like and Block action
     * One function for each function that returns String which will be shown in the UI
     * @return string "Liked" if like button is clicked, "Blocked" if block button is clicked
     */
    @Override
    //Function that will be call in controller if like is pressed
    public String presenterLike(){
        return "Liked";
    }

    @Override
    //Function that will be call in controller if block is pressed
    public String presenterBlock(){
        return "Blocked";
    }
}
