package tutorial;

import Entities.UserAccount;
import Entities.UserDatabase;
import FrameworksDrivers.DataAccess;
import UseCase.DatabaseManager;
import UseCase.Search;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;





// unable to do the testing since there's error in other teammate's part





public class SearchTest {

    @Test
    public void SearchNoOccurrence(){
        DataAccess access = new DataAccess();
        access.read_csv();
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
