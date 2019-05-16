package hotelmng.model.person;

import org.apache.log4j.Logger;

/**
 * Receptionist is an employee that will be able to confirm and cancel reservations based on client's request
 */


public class Receptionist extends Employee {

    private Logger log = Logger.getLogger("HouseKeeper");

    public Receptionist(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        log.info("Confirms/cancels reservations");
    }

}
