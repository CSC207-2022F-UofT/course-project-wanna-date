package useCase;

public interface RegistrationInputBoundary {

    boolean isValidRegistration(String username,
                                String full_name,
                                int age,
                                String pronouns,
                                String country, String province, String city,
                                String gender,
                                String sexuality,
                                String interest,
                                String password);
}
