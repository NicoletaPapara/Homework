package hotelmng.model.person;

/**
 * KitchenStaff is an employee that will be able to make food
 */

public class KitchenStaff extends Employee {

    public KitchenStaff(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        //makes/serves food
    }


}
