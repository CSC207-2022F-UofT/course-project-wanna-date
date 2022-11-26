package tutorial;

import entities.UserAccount;
import useCase.DatabaseManager;
import useCase.Search;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


// To use the test, comment the line this.presenter.showResult(results); in search class


public class SearchTest {
    DatabaseManager manager = DatabaseManager.getDatabaseManager();
    String[] sample = {"test4,Test 4,44,She/Her,null,null,null,F,H,Others,44448888",
            "lov12,Lovina,20,She/Her,null,null,null,F,H,Music,12345678",
            "panda,Peter Panda,33,He/Him,null,null,null,M,B,Exercise,12345678",
            "test2,Test 2,22,He/Him,null,null,null,M,G,Culinary,22222222"
            };


    @Test
    public void SearchNoOccurrence(){
        manager.createDatabase(sample);
        Search search = new Search();
        UserAccount[] expected = {};
        Assertions.assertEquals(expected.length, search.search("name").length);

    }

    @Test
    public void SearchOneOccurrence(){
        manager.createDatabase(sample);
        Search search = new Search();
        Assertions.assertEquals(1, search.search("lov").length);
        Assertions.assertEquals("lov12", search.search("lov")[0].get_username());

    }

    @Test
    public void SearchMultipleOccurrence(){
        manager.createDatabase(sample);
        Search search = new Search();
        Assertions.assertEquals(2, search.search("test").length);
        Assertions.assertEquals("test4", search.search("test")[0].get_username());
        Assertions.assertEquals("test2", search.search("test")[1].get_username());

    }

}
