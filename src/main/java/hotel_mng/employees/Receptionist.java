package hotel_mng.employees;

/**
 * Receptionist is an employee that will be able to confirm an cancel reservations based on client's request
 */

import hotel_mng.employees.Employee;



public class Receptionist extends Employee {

    public Receptionist(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }
}
