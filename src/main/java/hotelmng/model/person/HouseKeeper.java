package hotelmng.model.person;

/**
 * HouseKeeper is an employee that will be able to clean rooms
 */

public class HouseKeeper extends Employee {


    public HouseKeeper(int id, String cnp, String name) {
        super(id, cnp, name);
    }

    @Override
    public void works() {
        //cleans the rooms
    }


}
