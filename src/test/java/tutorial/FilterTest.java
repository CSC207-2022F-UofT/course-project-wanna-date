package tutorial;

import entities.UserAccount;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import useCase.*;

public class FilterTest {
    DatabaseManager manager = DatabaseManager.getDatabaseManager();
    //sample database for testing
    String[] sample = {"test4,Test 4,44,She/Her,trt,ON,CA,F,H,Others,44448888",
            "lov12,Lovina,20,She/Her,trt,ON,CA,F,H,Music,12345678",
            "panda,Peter Panda,33,He/Him,trt,ON,CA,M,B,Exercise,12345678",
            "test2,Test 2,22,He/Him,null,null,null,M,G,Culinary,22222222"
    };

    // test no occurrence of suitable user account in database for all three types of filters
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

    // test the functionality for the male type filter
    @Test
    public void FilterTypeMale(){
        manager.createDatabase(sample);
        FilterType type1 = new SexFilterFemaleType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type1).length);
        Assertions.assertEquals("lov12", filter.apply(type1)[1].getUsername());

    }

    // test the functionality for the female type filter
    @Test
    public void FilterTypeFemale(){
        manager.createDatabase(sample);
        FilterType type = new SexFilterMaleType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type).length);
        Assertions.assertEquals("test2", filter.apply(type)[1].getUsername());

    }

    // test the functionality for the location type filter
    @Test
    public void FilterTypeLocation(){
        manager.createDatabase(sample);
        CurrUserManager currUserManager = CurrUserManager.getCurrUserManager();
        currUserManager.setCurrUsername("lov12");
        FilterType type2 = new LocationFilterType();
        FilterUseCase filter = new FilterUseCase();
        Assertions.assertEquals(2, filter.apply(type2).length);
        Assertions.assertEquals("test4", filter.apply(type2)[1].getUsername());
    }

}
