package use_case.like;
import interface_adapters.like.PresenterLikeBlock;

public class RetrieveBlock {
    /** Use case that is allowed to call function in presenter.
     * Responsible for sending updated information from ReceiveBlock back to presenter
     */

    //Function that connect ReceiveBlock with this class to make sure presenter is called
    public void connector(){
        RetrieveBlockOutputBoundary param1 = new PresenterLikeBlock();
        block_view(param1);
    }
    // Function that call functions in Output Boundary that is implemented in presenter
    public void block_view(RetrieveBlockOutputBoundary view){
        view.presenterBlock();
    }



}