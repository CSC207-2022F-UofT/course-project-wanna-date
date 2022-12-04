//package interfaceAdapters;
//
//import entities.UserAccount;
//import UI.FilterMenu;
//import UI.SearchBox;
//import useCase.SearchFilterOutputBoundary;
//
//public class SearchFilterPresenter implements SearchFilterOutputBoundary {
//    public SearchBox box = null;
//    public FilterMenu menu = null;
//
//    public SearchFilterPresenter(SearchBox view){
//        this.box = view;
//    }
//
//    public SearchFilterPresenter(FilterMenu menu){
//        this.menu = menu;
//    }
//
//    // Present the results that generated from use case
//    @Override
//    public void showResult(UserAccount[] results) {
//        if (this.box != null) {
//            box.setResult(results);
//        } if (this.menu != null) {
//            menu.setResult(results);
//        }
//    }
//}
