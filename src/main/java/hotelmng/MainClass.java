package hotelmng;

import hotelmng.employees.*;
import hotelmng.hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        //Hotel myHotel = new Hotel("Nico's Hotel", "103, MyStreet, MyTown", 32);

        // creates the list of employees

        List<Employee> employeesList = new ArrayList<Employee>();

        employeesList.add(new Receptionist(1234, "Didi", "aaa", "07xx xxx xxx"));
        employeesList.add(new KitchenStaff(2345, "Vivi", "bbb", "07yy yyy yyy"));
        employeesList.add(new HouseKeeper(3456, "Bibi", "ccc", "07zz zzz zzz"));

        System.out.println(employeesList);

    }

}
