package hotelmng.model.person;

import org.apache.log4j.Logger;

/**
 * HouseKeeper is an employee that will be able to clean rooms
 */

public class HouseKeeper extends Employee {

    private Logger log = Logger.getLogger("HouseKeeper");


    public HouseKeeper(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    @Override
    public void works() {
        log.info("Cleans the rooms");
    }


}
