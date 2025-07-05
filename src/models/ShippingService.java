package models;


import interfaces.IShippable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ShippingService {
    public static void send(List<IShippable> items) {
        double totalWeight = 0;
        Map<String, Integer> count = new HashMap<>();

        System.out.println("** Shipment notice **");

        for (IShippable item : items) {
            count.put(item.getName(), count.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            System.out.println(entry.getValue() + "x " + entry.getKey());
        }

        System.out.printf("Total package weight: %.1fkg%n", totalWeight/1000);
    }
}