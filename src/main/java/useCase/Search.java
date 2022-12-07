package useCase;


import entities.UserAccount;
import interfaceAdapters.testPresenter;

import java.util.ArrayList;


public class Search implements SearchInputBoundary {
    public SearchFilterOutputBoundary presenter;

    // constructor method that allow UI to pass in presenter.
    public Search(SearchFilterOutputBoundary presenter){this.presenter = presenter;}

    // override constructor method just for test uses.
    public Search(){this.presenter = new testPresenter();}

    /**
     * Return a list of profiles whose username contains the given key word.
     * @param name Input from user to search.
     */

    @Override
    public UserAccount[] search(String name) {
        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
        // do the search here and give a result
        String[] username = databaseManager.listUsername();
        ArrayList<UserAccount> match= new ArrayList<>();
        for (String user : username){
            if (user.contains(name)){
                match.add(databaseManager.retrieveUserAccount(user));
            }
        }
        int size = match.size();
        UserAccount[] results = match.toArray(new UserAccount[size]);
        // show result
        this.presenter.showResult(results);
        return results;

    }


}
