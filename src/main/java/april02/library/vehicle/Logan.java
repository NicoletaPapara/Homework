package april02.library.vehicle;

public class Logan extends Dacie {

    private final String chassisNumber;

    public Logan(int fuelTankSize, String chassisNumber) {
        super(fuelTankSize);
        this.chassisNumber = chassisNumber;
    }
}
