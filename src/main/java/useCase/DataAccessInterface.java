package useCase;

import java.io.IOException;

public interface DataAccessInterface {

    String[] read_csv();

    void write_csv(Object[][] data_to_csv) throws IOException;
}
