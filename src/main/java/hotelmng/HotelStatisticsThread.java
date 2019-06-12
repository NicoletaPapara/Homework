package hotelmng;

import hotelmng.model.hotel.Hotel;
import org.apache.log4j.Logger;

import java.util.LinkedList;

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
