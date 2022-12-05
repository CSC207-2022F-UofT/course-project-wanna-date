package useCase;

public interface RecInputBoundary {

    /**
     * Make recommendations with information already stored
     * in the program, calling an OutputBoundary object
     * to do such processing.
     */
    public default void makeRecommendations(){};
}
