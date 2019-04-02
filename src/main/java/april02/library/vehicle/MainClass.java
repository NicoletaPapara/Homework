package april02.library.vehicle;

public class MainClass {
    public static void main(String[] args) {
        //Car car = new Car();
       // Car car = new Dacie (27, "abc");
        Car car =new Logan (27, "abc");
        car.setAvailableFuel(100);

        car.start();

        car.shiftGear(1);

        car.drive(0.01);// drives 0.01 KMs

        car.shiftGear(2);

        car.drive(0.02);

        car.shiftGear(3);

        car.drive(0.5);

        car.shiftGear(4);

        car.drive(0.5);

        car.shiftGear(4);

        car.drive(0.5);

        car.shiftGear(5);

        car.drive(10);

        car.shiftGear(4);

        car.drive(0.5);

        car.shiftGear(3);

        car.drive(0.1);

        car.stop();

//        float availableFuel = car.getAvailableFuel();
//
//        float fuleConsumedPer100Km = car.getAverageFuelConsumption();



//        Vehicle vehicle = new VWGolf(30, "1987ddkshik289"); //available fuel and chassis number
//
//        vehicle.start();
//
//        vehicle.drive(1km);
//
//        vehicle.stop();
//
//        Car car = (Car) vehicle;
//
//        float availableFuel = car.getAvailableFuel();
//
//        float fuleConsumedPer100Km = car.getAverageFuelConsumption();
    }
}
