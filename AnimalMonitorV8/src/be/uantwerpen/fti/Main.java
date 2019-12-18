package be.uantwerpen.fti;

import java.util.HashMap;
import java.util.Map;

// this is the Java 8 version (chapter 05 - BlueJ
public class Main {

    public static void main(String[] args) {
	// write your code here
        AnimalMonitor monitor = new AnimalMonitor();
        monitor.addSightings("SightingsNew.csv");

        System.out.println("---[Dier]---");
        monitor.printSightingsOf("Topi");

        System.out.println("---[Park]---");
        monitor.printSightingsFrom("Odzala National Park");

        System.out.println("--[Count1]--");
        System.out.println(monitor.getCountOfAnimals("Buffalo"));

        System.out.println("--[Count2]--");
        System.out.println(monitor.getCountOfAnimalsSeenBy("Topi","Francis"));

        System.out.println(monitor.makeMapOf("Jean"));

        /*System.out.println("*** all observations ");
        monitor.printList();
        System.out.println("*** all Buffalo observations ");
        monitor.printSightingsOf("Buffalo");*/

    }
}
