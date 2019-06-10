package hotelmng;

import lombok.Getter;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class CheckInData {

    private Date checkInDate;
    private int numberOfPeople;

    Random random = new Random();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public CheckInData() {
        //generates a random check in date within a month
        this.checkInDate = new Date(ThreadLocalRandom.current()
                .nextLong(new Date().getTime(), DateUtils.addDays(new Date(), 30).getTime()));
        this.numberOfPeople = random.nextInt(10) + 1;
    }



    @Override
    public String toString() {
        return "Check in date: " + formatter.format(checkInDate) + ", number of people: " + numberOfPeople;
    }
}
