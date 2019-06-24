package test.finalquiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Setter
public class Package {
    private String targetLocation;
    private int targetDistance;
    private int packageValue;
    private LocalDate deliveryDate;


    @Override
    public String toString() {
        return targetLocation + " "
                + packageValue + " "
                + targetDistance + " "
                + deliveryDate.toString();
    }

}
