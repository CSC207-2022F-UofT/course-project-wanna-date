package tutorial;

import entities.UserAccount;
import entities.UserDatabase;
import useCase.DatabaseManager;
import useCase.Search;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;





// unable to do the testing since there's error in other teammate's part





public class SearchTest {

    @Test
    public void SearchNoOccurrence(){
        DatabaseManager dm = DatabaseManager.getDatabaseManager();
        String[] data = {};
        dm.createDatabase(data);
        UserDatabase database = dm.getDatabase();
        Search search = new Search();
        UserAccount[] expected = {};
        Assertions.assertEquals(expected, search.search("name"));

    }

    @Test
    public void SearchOneOccurrence(){

    }

    @Test
    public void SearchMultipleOccurrence(){

    }

}
