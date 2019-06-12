package hotelmng;

import hotelmng.model.hotel.Hotel;

import java.util.LinkedList;

public class ClientThread extends Thread {

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
