package tutorial;

import Entities.UserAccount;
import Entities.UserDatabase;
import UseCase.DatabaseManager;
import UseCase.Search;
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
