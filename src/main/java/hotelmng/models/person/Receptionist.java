package hotelmng.models.person;

import hotelmng.models.person.Employee;

/**
 * Receptionist is an employee that will be able to confirm and cancel reservations based on client's request
 */


public class Receptionist extends Employee {

    public Receptionist(int id, int cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        //confirms/cancels reservations
    }

}
