package hotelmng.employees;

/**
 * KitchenStaff is an employee that will be able to make food
 */

public class KitchenStaff extends Employee {

    public KitchenStaff(int id, String name, String address, String phoneNumber) {
        super(id, name, address, phoneNumber);
    }

    public void works() {
        //makes/serves food
    }


}
