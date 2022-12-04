//package useCase;
//
//
//import entities.UserAccount;
//
//import java.util.ArrayList;
//
//
//public class Search implements SearchInputBoundary {
//    public SearchFilterOutputBoundary presenter = null;
//
//
//    /**
//     * used in controller to set the presenter to present the result.
//     * @param  presenter Presenter to present the result.
//     */
//    public void setPresenter(SearchFilterOutputBoundary presenter){
//        this.presenter = presenter;
//    }
//
//    /**
//     * Return a list of profiles whose username contains the given key word.
//     * @param name Input from user to search.
//
//     */
//
//    @Override
//    public UserAccount[] search(String name) {
//        DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
//        // do the search here and give a result
//        String[] username = databaseManager.list_username();
//        ArrayList<UserAccount> match= new ArrayList<>();
//        for (String user : username){
//            if (user.contains(name)){
//                match.add(databaseManager.retrieve_user_account(user));
//            }
//        }
//        int size = match.size();
//        UserAccount[] results = match.toArray(new UserAccount[size]);
//        // show result
//        this.presenter.showResult(results);
//
//        return results;
//
//    }
//
//
//}
