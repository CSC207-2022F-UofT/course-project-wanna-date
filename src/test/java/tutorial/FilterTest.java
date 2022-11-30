package tutorial;

import entities.UserAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import useCase.*;


// To use the test, comment the line this.presenter.showResult(results); in FilterUseCase class



public class FilterTest {
    DatabaseManager manager = DatabaseManager.getDatabaseManager();
    String[] sample = {"test4,Test 4,44,She/Her,trt,ON,CA,F,H,Others,44448888",
            "lov12,Lovina,20,She/Her,trt,ON,CA,F,H,Music,12345678",
            "panda,Peter Panda,33,He/Him,trt,ON,CA,M,B,Exercise,12345678",
            "test2,Test 2,22,He/Him,null,null,null,M,G,Culinary,22222222"
    };

    @Test
    public void FilterNoOccurrence(){
        String[] empty = {};
        manager.createDatabase(empty);
        FilterType type = new SexFilterMaleType();
        FilterType type1 = new SexFilterFemaleType();
        FilterType type2 = new LocationFilterType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(0, filter.apply(type).length);
        Assertions.assertEquals(0, filter.apply(type1).length);
        Assertions.assertEquals(0, filter.apply(type2).length);

    }

    @Test
    public void FilterTypeMale(){
        manager.createDatabase(sample);
        FilterType type1 = new SexFilterFemaleType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type1).length);
        Assertions.assertEquals("lov12", filter.apply(type1)[1].get_username());

    }

    @Test
    public void FilterTypeFemale(){
        manager.createDatabase(sample);
        FilterType type = new SexFilterMaleType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type).length);
        Assertions.assertEquals("test2", filter.apply(type)[1].get_username());

    }

    @Test
    public void FilterTypeLocation(){
        manager.createDatabase(sample);
        CurrUser curr = CurrUser.getCurrUser();
        curr.setCurrUsername("lov12");
        FilterType type2 = new LocationFilterType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type2).length);
        Assertions.assertEquals("test4", filter.apply(type2)[1].get_username());
    }

}
