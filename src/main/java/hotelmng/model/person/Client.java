package hotelmng.model.person;

/**
 * This class models a client
 */

public class Client {

    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Title title;

    public Client(String name, Title title) {
        this.name = name;
        this.title = title;
    }
}
