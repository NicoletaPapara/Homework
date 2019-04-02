package april02.library.vehicle;

public class Car implements IVehicle{

    private int availableFuel;

    private int consumptionRate;
    private double averageFuelConsumption;

    private final int fuelTankSize;
    private final int consumptionPer100km = 4;

    public Car(int fuelTankSize) {
        this.fuelTankSize = fuelTankSize;
    }

    public void setAvailableFuel(int availableFuel) {
        this.availableFuel = availableFuel;
    }

    public int getAvailableFuel() {
        return availableFuel;
    }

    public void start() {
        //consumption return to 0
    }

    public void stop() {

    }

    public void drive(double kms) {
        //consumptionRate
        //availableFuel modified
    }

    public void shiftGear(int gear) {
        switch (gear) {
            case 1:
                consumptionRate = 8;
                break;
            case 2 :
                consumptionRate = 7;
                break;
            case 3 :
                consumptionRate = 6;
                break;
            case 4 :
                consumptionRate = 5;
                break;
            case 5:
                consumptionRate = consumptionPer100km;
                break;
                default:
                    consumptionRate=3;
                    break;
        }
    }
}
