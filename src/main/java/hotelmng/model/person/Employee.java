package hotelmng.model.person;


import java.util.Calendar;

/**
 * This class models an employee
 */

public abstract class Employee {

    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 60;
    private final int id;
    private final String cnp;
    private String name;
    private boolean isAtWork = false;

    public Employee(int id, String cnp, String name) {
        this.id = id;
        this.cnp = cnp;
        this.name = name;
    }

    public boolean isAtWork() {
        return isAtWork;
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

    protected abstract void works();

    public int getAge() {
        String birthYear = cnp.substring(1, 3);

        int year1 = Integer.parseInt(birthYear);

        if (year1 < 19) {
            year1 = 2000 + year1;
        } else {
            year1 = 1900 + year1;
        }

        int year2 = Calendar.getInstance().get(Calendar.YEAR);

        return year2 - year1;
    }

    public static int getMinAge() {
        return MIN_AGE;
    }

    public static int getMaxAge() {
        return MAX_AGE;
    }

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
