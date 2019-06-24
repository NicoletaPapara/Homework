package test.finalquiz;

import java.util.concurrent.ConcurrentLinkedQueue;

public class TotalValues extends Thread {
    private ConcurrentLinkedQueue<Package> deliveredGroups;

    public TotalValues(ConcurrentLinkedQueue<Package> deliveredGroups) {
        this.deliveredGroups = deliveredGroups;
    }

    @Override
    public void run() {
        int totalValue = 0;
        int totalRevenue = 0;
        for (Package pack : deliveredGroups) {
            totalValue += pack.getPackageValue();
            totalRevenue += pack.getTargetDistance();
        }
        System.out.println("Total value: "
                + totalValue
                + " and total revenue: "
                + totalRevenue + " LEI");
    }
}
