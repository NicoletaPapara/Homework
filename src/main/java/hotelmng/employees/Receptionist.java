package hotelmng.employees;

/**
 * Receptionist is an employee that will be able to confirm and cancel reservations based on client's request
 */


public class Receptionist extends Employee {

    public Receptionist(int id, String name, String address, String phoneNumber) {
        super(id, name, address, phoneNumber);
    }

    public void works() {
        //confirms/cancels reservations
    }


}
