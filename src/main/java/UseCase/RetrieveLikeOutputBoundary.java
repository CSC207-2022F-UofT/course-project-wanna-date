package useCase;

public interface RetrieveLikeOutputBoundary {
    /** Like Output Boundary.
     * Create function that will be override in presenter
     * @return null to indicate function with no implementation is called
     */
    default String presenterLike(){
        return null;
    }
}