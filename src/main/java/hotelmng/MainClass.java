package hotelmng;

import hotelmng.model.hotel.Hotel;
import hotelmng.model.person.Employee;
import hotelmng.model.person.HouseKeeper;
import hotelmng.model.person.Receptionist;
import hotelmng.service.EmployeeService;
import hotelmng.service.EmployeeAgeValidationException;
import org.apache.log4j.Logger;


public class MainClass {

    private static Logger logger = Logger.getLogger("MainClass");

    @SuppressWarnings({"deprecation"})
    public static void main(String[] args) {

        Hotel myHotel = new Hotel("Nico's Hotel", 32);
        myHotel.setAddress("51 Main Street, Cluj Napoca, Romania");


        logger.info(myHotel.getName() +
                " is located at " + myHotel.getAddress() +
                " and has " + myHotel.getNumberOfRooms() + " rooms. The hotel is " + myHotel.checkHotelBookingStatus() + " % booked.");

        Employee emp1 = new Receptionist(1234, "1050596555555", "Alex Popescu");
        Employee emp2 = new HouseKeeper(1235, "2840596552222", "Maria Muntean");

        logger.info("Currently, the following emplyoees are working for the hotel: ");
        logger.info(emp1.toString());
        logger.info(emp2.toString());

        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.validateAndAdd(emp1);
        } catch (EmployeeAgeValidationException e) {
            logger.error(e.getMessage());
        }

    }

}
