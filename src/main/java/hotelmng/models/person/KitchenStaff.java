package hotelmng.models.person;

import hotelmng.models.person.Employee;

/**
 * KitchenStaff is an employee that will be able to make food
 */

public class KitchenStaff extends Employee {

    public KitchenStaff(int id, long cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        //makes/serves food
    }


}
