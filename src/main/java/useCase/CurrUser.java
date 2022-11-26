package useCase;

public class CurrUser {

    private static CurrUser currUser;
    private String username;

    private CurrUser() {
    }

    public static CurrUser getCurrUser() {
        if (currUser == null)
            currUser = new CurrUser();
        return currUser;
    }

    public void setCurrUsername(String username) {
        this.username = username;
    }

    public String getCurrUsername() {
        return this.username;
    }
}
