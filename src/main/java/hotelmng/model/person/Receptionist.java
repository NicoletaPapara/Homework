package hotelmng.model.person;

/**
 * Receptionist is an employee that will be able to confirm and cancel reservations based on client's request
 */


public class Receptionist extends Employee {

    public Receptionist(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        //confirms/cancels reservations
    }

}
