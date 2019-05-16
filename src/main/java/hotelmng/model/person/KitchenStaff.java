package hotelmng.model.person;

import org.apache.log4j.Logger;

/**
 * KitchenStaff is an employee that will be able to make food
 */

public class KitchenStaff extends Employee {

    private Logger log = Logger.getLogger("HouseKeeper");

    public KitchenStaff(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    public void works() {
        log.info("Makes/serves food");
    }


}
