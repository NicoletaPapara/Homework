package hotelmng;

import hotelmng.exception.EmployeeAgeValidationException;
import hotelmng.model.room.Room;
import hotelmng.model.hotel.Hotel;
import hotelmng.model.hotel.MealPreference;
import hotelmng.model.hotel.Reservation;
import hotelmng.model.person.Client;
import hotelmng.model.person.Employee;
import hotelmng.model.person.HouseKeeper;
import hotelmng.model.person.Receptionist;
import hotelmng.service.EmployeeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MainClass {

    private static Logger logger = Logger.getLogger("MainClass");


    public static void main(String[] args) {

        Hotel myHotel = new Hotel("Nico's Hotel", 32);
        myHotel.setAddress("51 Main Street, Cluj Napoca, Romania");


        logger.info(myHotel.getName() +
                " is located at " + myHotel.getAddress() +
                " and has " + myHotel.getNumberOfRooms() + " rooms.");

        //IO examples & builder pattern example

        readReservationDetails();
        readRoomInformation().forEach(System.out::println);

        //Custom exception example

        customExceptionExample();


        //writes Hotel data in a non-readable file (serialization) and then reads it (deserialization)

        hotelSerialization(myHotel);
        hotelDeserialization("myHotel.obj");

        //enum example

        enumExample();

        //> Use a SET in your project (condition: 2 clients with the same cnp cannot be added)
        //
        //Observation: create 20 clients in your application with random data (name / cnp for example),
        // at least 3 clients with the same cnp. Create a Set illustrating that you cannot add @equal
        // elements in a Set. To create the clients use: index, random number generator or files (as you prefer).

        Set<Client> clients1 = buildASetOfClients(20);
        clients1.forEach(client -> logger.info(client));

        //> Order or Sort a LIST

        // Observation: create 10 rooms and add them to a list with the possibility to sort them by name
        // (ascending / descending)

        List<Room> rooms = createAListOfRoomsAndOrderByName(10);
        rooms.forEach(room -> logger.info(room));

        //> Use a MAP in your project
        //
        //Observation: add a type Long (long) / UUID id in your Hotel model and create a map
        // structure that makes sense (ex: <K,V> => <hotel identifier, list of rooms>)

        mapExample();

        //wildcard example

        logger.info("Average age of random Employee list is: ");
        logger.info(calculateEmployeesAverageAge(generateRandomEmployeeList(4)));

        //Optional example

        optionalExample();

        streamOperationsExample();

        threadExample();
    }

    private static void threadExample() {

        Hotel myHotel = new Hotel("My Hotel", 50);

        HotelStatisticsThread hotelStatisticsThread = new HotelStatisticsThread(myHotel);
        new Thread(hotelStatisticsThread).start();

        for (int i = 0; i < 100; i++) {
            ClientThread clientThread = new ClientThread(new CheckInData(), myHotel);
            clientThread.start();
        }
    }

    private static void streamOperationsExample() {

        //counts the number of employees that are 25 years old from a random employee list
        logger.info(generateRandomEmployeeList(10).stream().filter(employee -> employee.getAge() == 25).count());

        //checks if there are any available rooms
        List<Room> rooms = readRoomInformation();
        logger.info("There are available rooms: " + rooms.stream().anyMatch(room -> !room.isReserved()));

        //sorts the hotels by number of rooms
        Hotel hotel1 = new Hotel("Beethoven", 90);
        Hotel hotel2 = new Hotel("Chopin", 80);
        Hotel hotel3 = new Hotel("Verdi", 70);

        Stream.of(hotel1, hotel2, hotel3)
                .sorted(Comparator.comparingInt(Hotel::getNumberOfRooms))
                .forEach(System.out::println);

        //collects clients' email addresses in a list

        List<Client> clients = generateRandomClientList(10);

        List<String> emails = clients
                .stream()
                .map(Client::getEmailAddress)
                .collect(Collectors.toList());

    }

    private static List<Client> generateRandomClientList(int size) {
        List<Client> clients = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            clients.add(Client.builder().
                    emailAddress(RandomStringUtils.random(10, true, false))
                    .build());
        }
        return clients;
    }

    private static void optionalExample() {

        //prints the eldest employee
        List<Employee> employees = generateRandomEmployeeList(10);
        Optional<Employee> eldestEmployee = employees.stream().max(Comparator.comparingInt(Employee::getAge));
        if (eldestEmployee.isPresent()) {
            logger.info("Eldest employee is: " + eldestEmployee.get());
        }

        //prints the youngest employee
        employees.stream().reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2).ifPresent(employee -> System.out.println("Youngest employee is: " + employee));
    }

    public static void customExceptionExample() {
        Employee emp1 = new Receptionist(1234, "1050596555555", "Alex Popescu");

        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.validateAndAdd(emp1);
        } catch (EmployeeAgeValidationException e) {
            logger.error(e.getMessage());
        }
    }

    public static void enumExample() {
        Reservation reservation = new Reservation("2019-05-18", "2019-05-20", MealPreference.REGULAR);
        logger.info(reservation.getMealPreference());
        logger.info(reservation.getMealPreference().getMessage());
        logger.info(reservation.getMealPreference().isPreOrderRequired());
    }

    public static void mapExample() {

        Map<UUID, List<Employee>> employeeMap = new Hashtable<>();

        Hotel hotel1 = new Hotel("Beethoven", 90);
        Hotel hotel2 = new Hotel("Chopin", 80);
        Hotel hotel3 = new Hotel("Verdi", 70);

        employeeMap.put(hotel1.getId(), generateRandomEmployeeList(4));
        employeeMap.put(hotel2.getId(), generateRandomEmployeeList(3));
        employeeMap.put(hotel3.getId(), generateRandomEmployeeList(5));

        logger.info("EmployeesMap has " + employeeMap.size() + " entries.");

//        for(UUID key: employeeMap.keySet()){
//            System.out.println(employeeMap.get(key));
//        }

        employeeMap.values().forEach(value -> logger.info(value));
    }

    private static List<Employee> generateRandomEmployeeList(int size) {

        List<Employee> employees = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= size; i++) {
            Employee employee = new HouseKeeper(
                    random.nextInt(10000),
                    RandomStringUtils.random(13, false, true),
                    RandomStringUtils.random(5, true, false) + " " + RandomStringUtils.random(5, true, false));
            employees.add(employee);
        }
        return employees;
    }

    private static List<Room> createAListOfRoomsAndOrderByName(int numberOfRooms) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            String roomName = RandomStringUtils.random(4, true, false);
            rooms.add(Room.builder().roomNumber(i).name(roomName).build());
        }
        Comparator<Room> sortByName = Comparator.comparing(Room::getName);
        rooms.sort(sortByName);
        return rooms;
    }

    public static Set<Client> buildASetOfClients(int n) {
        Set<Client> clients = new HashSet<>();

        for (int i = 1; i < n; i++) {
            String cnp = RandomStringUtils.random(13, false, true);
            String name = RandomStringUtils.random(4, true, false);
            clients.add(Client.builder().cnp(cnp).name(name).build());
        }

        logger.info(clients.size());

        //clients having the same cnp cannot be added to the set

        clients.add(Client.builder().cnp("1050596555555").name("Victor").build());
        clients.add(Client.builder().cnp("1050596555555").name("Alex").build());
        clients.add(Client.builder().cnp("1050596555555").name("Lucien").build());

        logger.info(clients.size());
        return clients;
    }

    private static double calculateEmployeesAverageAge(List<? extends Employee> list) {
        double sum = 0;
        Iterator<? extends Employee> i = list.iterator();
        while (i.hasNext()) {
            sum += i.next().getAge();
        }
        return sum / list.size();
    }

    public static void hotelSerialization(Hotel myHotel) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myHotel.obj"));
            oos.writeObject(myHotel);
            oos.flush();
            oos.close();

        } catch (IOException e) {
            logger.error("Cannot find the file");
        }
    }

    public static void hotelDeserialization(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            Hotel myHotel2 = (Hotel) obj;
            logger.info(myHotel2);
        } catch (IOException e) {
            logger.error("Cannot find the file");
        } catch (ClassNotFoundException e) {
            logger.error(e);
        }

    }

    public static void readReservationDetails() {
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
    }

    public static List<Room> readRoomInformation() {
        List<Room> rooms = new ArrayList<>();

        Charset charset2 = Charset.forName("UTF8");
        Path path2 = Paths.get("rooms.txt");

        try (BufferedReader reader = Files.newBufferedReader(path2, charset2)) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                rooms.add(Room.builder()
                        .roomNumber(Integer.parseInt(tokens[0]))
                        .isReserved(Boolean.getBoolean(tokens[1]))
                        .name(tokens[2])
                        .build());
            }
        } catch (IOException e) {
            logger.error("Cannot find the file");
        }
        return rooms;
    }
}

class ClientThread extends Thread {

    private CheckInData checkInData;
    private Hotel hotel;
    private LinkedList<CheckInData> checkInDataList;

    public ClientThread(CheckInData checkInData, Hotel hotel) {
        this.checkInData = checkInData;
        this.hotel = hotel;

        this.checkInDataList = hotel.getCheckInDataList();
    }

    @Override
    public void run() {
        synchronized (checkInDataList) {
            checkInDataList.add(checkInData);
        }
    }
}

class HotelStatisticsThread implements Runnable {
    private Logger logger = Logger.getLogger("Hotel Statistics Thread");
    private LinkedList<CheckInData> list;

    HotelStatisticsThread(Hotel hotel) {
        this.list = hotel.getCheckInDataList();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
//                    list.forEach(System.out::println);

                    //prints how many people have checked in
                    int numberOfPeopleCheckedIn = 0;
                    for (int i = 0; i < list.size(); i++) {
                        numberOfPeopleCheckedIn += list.get(i).getNumberOfPeople();
                    }
                    logger.info("Number of people that have checked in: " + numberOfPeopleCheckedIn);

                    //prints how many check-ins have been done before 12:00 p.m.;
                    logger.info("Number of check-ins before 12 p.m. : " + getNumberOfCheckInsBeforeNoon(list));

                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public int getNumberOfCheckInsBeforeNoon(LinkedList<CheckInData> list) {

        int i = 0;

        for (CheckInData checkInData : list) {

            if (checkInData.getCheckInDate().getHours() < 12) {
                i++;
            }
        }
        return i;
    }
}