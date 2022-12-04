package entities;

public class BasicUserAccount extends UserAccount{
    /** Subclass of UserAccount.
     * Adhere to SOLID Principle where it allows us to extend our code in the future
     * @param username username of the user
     * @param full_name full name
     * @param age age of the user
     * @param pronouns she/he/they/them
     * @param country country they reside
     * @param province province they reside
     * @param city city they resider
     * @param gender Female/Male/Non-binary
     * @param sexuality gay/lesbian/heterosexual/bisexual
     * @param interest They can only name one interest most suitable to them from this list:
     *      - Culinary
     *      - Sports
     *      - Watching
     *      - Photography
     *      - Travelling
     *      - Fashion
     *      - Music
     *      - Exercise
     *      - Games
     *      - Socializing
     *      - Others
     * @param password password used to log in
     */
    public BasicUserAccount(String username, String full_name, int age, String pronouns, String country,
                            String province, String city, String gender, String sexuality, String interest,
                            String password) {
        super(username, full_name, age, pronouns, country, province, city, gender, sexuality, interest, password);
    }
}
