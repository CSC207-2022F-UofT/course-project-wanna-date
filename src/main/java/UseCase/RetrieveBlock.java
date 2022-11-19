package UseCase;
import InterfaceAdapters.PresenterLikeBlock;
import UI.UserLikeBlock;

public class RetrieveBlock {



    public void connector(){
        RetrieveBlockOutputBoundary param1 = new PresenterLikeBlock();
        block_view(param1);
    }
    public void block_view(RetrieveBlockOutputBoundary view){
       view.presenterBlock();
    }



}
