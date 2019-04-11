package hotelmng.employees;

/**
 * HouseKeeper is an employee that will be able to clean rooms
 */

public class HouseKeeper extends Employee {


    public HouseKeeper(int id, String name, String address, String phoneNumber) {
        super(id, name, address, phoneNumber);
    }

    @Override
    public void works() {
        //cleans the rooms
    }


}
