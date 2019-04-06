package hotel_mng.employees;

/**
 * This class models an employee
 */

public class Employee {

    private String name;
    private String address;
    private String phoneNumber;

    private boolean isAtWork;

    public Employee(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
