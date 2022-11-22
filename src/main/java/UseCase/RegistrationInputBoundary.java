package UseCase;

import Entities.UserDatabase;

public interface RegistrationInputBoundary {

    boolean isValidRegistration(UserDatabase database,
                                String username,
                                String full_name,
                                int age,
                                String pronouns,
                                String country, String province, String city,
                                String gender,
                                String sexuality,
                                String interest,
                                String password);
}
