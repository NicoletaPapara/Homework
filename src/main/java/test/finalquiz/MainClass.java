package test.finalquiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        List<Package> list;
        List<Package> group;
        ConcurrentLinkedQueue<Package> deliveredGroups = new ConcurrentLinkedQueue<>();

        list = loadDataFromFile();

        Set<String> locations = new HashSet<>();
        Set<LocalDate> dates = new HashSet<>();
        for (Package pack : list) {
            locations.add(pack.getTargetLocation());
            dates.add(pack.getDeliveryDate());
        }

        for (String location : locations) {
            for (LocalDate date : dates) {
                group = list.stream()
                        .filter(pack -> pack.getTargetLocation().equals(location)
                                && (pack.getDeliveryDate().compareTo(date) == 0)).collect(Collectors.toList());
                if (group.size() > 0) {
                    GroupDeliveryThread groupDeliveryThread = new GroupDeliveryThread(group, deliveredGroups);
                    groupDeliveryThread.start();
                    groupDeliveryThread.join();
                }
            }
        }

        TotalValues t = new TotalValues(deliveredGroups);
        t.start();
    }

    private static List<Package> loadDataFromFile() {

        List<Package> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(",");
                Package pack = new Package(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]),
                        LocalDate.parse(tokens[3], formatter));
                list.add(pack);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
