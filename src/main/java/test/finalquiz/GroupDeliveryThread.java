package test.finalquiz;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GroupDeliveryThread extends Thread{
    private List<Package> list;
    private String location;
    private LocalDate date;
    private ConcurrentLinkedQueue<Package> deliveredGroups;


    public GroupDeliveryThread(List<Package> list, ConcurrentLinkedQueue<Package> deliveredGroups) {
        this.list = list;
        this.deliveredGroups = deliveredGroups;
        this.location = list.get(0).getTargetLocation();
        this.date = list.get(0).getDeliveryDate();
    }

    @Override
    public void run() {
        int groupTotalValue = calculateGroupTotalValue(list);
        int groupTotalDistance = calculateGroupTotalDistance(list);

        deliveredGroups.add(new Package(location,groupTotalDistance,groupTotalValue,date));
        try {
            Thread.sleep(list.get(0).getTargetDistance() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("[Delivering for <"
                + location
                + "> and date <"
                + date.toString()
                +"> in <"
                + list.get(0).getTargetDistance()
                + "> seconds]");
    }

    private int calculateGroupTotalDistance(List<Package> list) {
        int groupDistance = 0;
        for(Package pack : list){
            groupDistance += pack.getTargetDistance();
        }
        return groupDistance;
    }

    private int calculateGroupTotalValue(List<Package> list) {
        int groupValue = 0;
        for(Package pack: list){
            groupValue += pack.getPackageValue();
        }
        return groupValue;
    }
}
