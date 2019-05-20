package hotelmng.model.person;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * This class models a client
 */
@Getter
@Setter
public class Client {
    private String cnp;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Title title;


    public Client(String cnp, String name, Title title) {
        this.cnp = cnp;
        this.name = name;
        this.title = title;
    }

    public Client(String cnp, String name) {
        this.cnp = cnp;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return cnp == client.cnp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    @Override
    public String toString() {
        return title + " " + name + " " + cnp;
    }
}
