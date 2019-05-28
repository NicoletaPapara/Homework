package hotelmng.model.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * This class models a client
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client {
    private String cnp;
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private Title title;


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
