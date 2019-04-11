package hotelmng.employees;

import org.junit.Test;

/**
 * This class models an employee
 */

public abstract class Employee {

    private final int id;
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isAtWork;
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;

    public Employee(int id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void checkIn() {
        this.isAtWork = true;
    }

    public void checkOut() {
        this.isAtWork = false;
    }

    public abstract void works();

    @Override
    public String toString() {
        return "Name: " + this.name + "(" + this.id + ")";
    }


}
