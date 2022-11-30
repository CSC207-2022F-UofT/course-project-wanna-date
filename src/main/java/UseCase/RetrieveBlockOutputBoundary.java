package useCase;

public interface RetrieveBlockOutputBoundary {
    /** OutputBoundary for Block.
     * Responsible for connecting use case with presenter as part of Clean Architecture
     * @return null to indicate that the wrong function (no implementation) is called
     */
    default String presenterBlock(){
        return null;
    }
}