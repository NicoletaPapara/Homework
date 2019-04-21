package hotelmng.models.person;


/**
 * This class models an employee
 */

public abstract class Employee {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;
    private final int id;
    private final int cnp;
    private String name;
    private String address;
    private String phoneNumber;
    private double hourlyWage;
    private int leaveDaysPerYear;

    public boolean isAtWork() {
        return isAtWork;
    }

    private boolean isAtWork = false;

    public Employee(int id, int cnp, String name) {
        this.id = id;
        this.cnp = cnp;
        this.name = name;
    }

    public int getLeaveDaysPerYear() {
        return leaveDaysPerYear;
    }

    public void setLeaveDaysPerYear(int leaveDaysPerYear) {
        this.leaveDaysPerYear = leaveDaysPerYear;
    }


    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return cnp == employee.cnp;

    }

    @Override
    public String toString() {
        return this.name + " (ID: " + this.id + ")";
    }


}
