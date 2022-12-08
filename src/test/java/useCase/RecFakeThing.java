package useCase;

public class RecFakeThing {

    private RecTestSingleton testy;
    private RecFakeOutsourcer outsourcer;

    public RecFakeThing(RecFakeOutsourcer o){
        this.testy = RecTestSingleton.getRecTestSingleton();
        this.outsourcer = o;
    }

    public String getX(){
        return this.outsourcer.getKnowledge();
    }

}
