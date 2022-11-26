package interfaceAdapters;
import useCase.RetrieveLikeOutputBoundary;
import useCase.RetrieveBlockOutputBoundary;

public class PresenterLikeBlock implements RetrieveBlockOutputBoundary, RetrieveLikeOutputBoundary{
    @Override
    public String presenterLike(){
        return "Liked";
    }

    @Override
    public String presenterBlock(){
        return "Blocked";
    }
}
