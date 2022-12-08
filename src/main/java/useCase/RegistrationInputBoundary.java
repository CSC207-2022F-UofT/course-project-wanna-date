package useCase;

/** InputBoundary for Registration feature.
 */
public interface RegistrationInputBoundary {

    /** Function with no implementation that will be overwritten in RegistrationManager class.
     */
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
