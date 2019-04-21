package hotelmng;

import hotelmng.models.hotel.Hotel;
import hotelmng.models.person.Employee;
import hotelmng.models.person.HouseKeeper;
import hotelmng.models.person.Receptionist;


public class MainClass {

    public static void main(String[] args) {

        Hotel myHotel = new Hotel("Nico's Hotel", 32);
        myHotel.setAddress("51 Main Street, Cluj Napoca, Romania");

        System.out.println(myHotel.getName() +
                " is located at " + myHotel.getAddress() +
                " and has " + myHotel.getNumberOfRooms() + " rooms. The hotel is " + myHotel.checkStatus() + " % booked.");

        Employee emp1 = new Receptionist(1234, 124059655, "Alex Popescu" );
        Employee emp2 = new HouseKeeper(1235, 224059655, "Maria Muntean");

        System.out.println("Currently, the following emplyees are working for the hotel: ");
        System.out.println(emp1.toString());
        System.out.println(emp2.toString());
    }

}
