package InterfaceAdapters;
import UseCase.RetrieveLikeOutputBoundary;
import UseCase.RetrieveBlockOutputBoundary;

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
