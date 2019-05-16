package hotelmng;

import hotelmng.exception.EmployeeAgeValidationException;
import hotelmng.model.hotel.Hotel;
import hotelmng.model.person.Employee;
import hotelmng.model.person.HouseKeeper;
import hotelmng.model.person.Receptionist;
import hotelmng.service.EmployeeService;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MainClass {

    private static Logger logger = Logger.getLogger("MainClass");


    public static void main(String[] args) {

        Hotel myHotel = new Hotel("Nico's Hotel", 32);
        myHotel.setAddress("51 Main Street, Cluj Napoca, Romania");


        logger.info(myHotel.getName() +
                " is located at " + myHotel.getAddress() +
                " and has " + myHotel.getNumberOfRooms() + " rooms.");

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

        //reads reservations' information from a file and prints it

        Charset charset = Charset.forName("UTF8");

        Path path = Paths.get("reservations.txt");

        try {
            BufferedReader reader = Files.newBufferedReader(path, charset);
            String line = null;

            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.error("Cannot find the file");
        }

        // reads room information from file
        Charset charset2 = Charset.forName("UTF8");
        Path path2 = Paths.get("rooms.txt");

        try (BufferedReader reader = Files.newBufferedReader(path2, charset2)) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }
        } catch (IOException e) {
            logger.error("Cannot find the file");
        }

        //writes Hotel data in a non-readable file (serialization) and then reads it (deserialization)

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myHotel.obj"));
            oos.writeObject(myHotel);
            oos.flush();
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myHotel.obj"));
            Object obj = ois.readObject();
            Hotel myHotel2 = (Hotel) obj;
            logger.info(myHotel2);


        } catch (IOException e) {
            logger.error("Cannot find the file");
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }

    }

}
