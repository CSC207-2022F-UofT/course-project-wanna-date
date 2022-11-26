package useCase;

public class RetrieveBlock {
    RetrieveBlockOutputBoundary param1;

    public RetrieveBlock(RetrieveBlockOutputBoundary OB_Block){
        this.param1 = OB_Block;
    }

    public void connector(){
        block_view(param1);
    }
    public void block_view(RetrieveBlockOutputBoundary view){
       view.presenterBlock();
    }

}
