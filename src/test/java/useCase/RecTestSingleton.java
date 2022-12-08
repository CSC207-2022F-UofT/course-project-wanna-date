package useCase;

public class RecTestSingleton {

    private static RecTestSingleton recTestSingleton;

    private RecTestSingleton() {
    }

    public static RecTestSingleton getRecTestSingleton() {
        if (recTestSingleton == null)
            recTestSingleton = new RecTestSingleton();
        return recTestSingleton;
    }
}
