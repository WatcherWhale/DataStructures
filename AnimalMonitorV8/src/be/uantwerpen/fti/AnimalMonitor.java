package be.uantwerpen.fti;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.03.01 (functional)
 */
public class AnimalMonitor
{
    private ArrayList<Sighting> sightings;

    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }

    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }

    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    /**
     * Print details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    public void printSightingsFrom(String park)
    {
        sightings.stream()
                .filter(sighting -> sighting.getArea().equals(park))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    public void printSightingsBy(String spotter)
    {
        sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }

    public void printShortSightingsBy(String spotter)
    {
        sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .forEach(sighting -> System.out.println(sighting.shortDetails()));
    }

    public void printAllAnimalsBy(String spotter, String animal)
    {
        sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                .forEach(sighting -> System.out.println(sighting.getDetails()));
    }


    public int getCountOfAnimals(String animal)
    {
        return sightings.stream()
                .filter(sighting -> sighting.getAnimal().equals(animal))
                .map(sighting -> sighting.getCount())
                .reduce(0, (sum , count) -> sum + count);
    }

    public int getCountOfAnimalsSeenBy(String animal, String spotter)
    {
        return sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                .map(sighting -> sighting.getCount())
                .reduce(0, (a,b) -> a+b);
    }

    public ArrayList<String> listSightingsBy(String spotter)
    {
        return sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .map(sighting -> sighting.getDetails())
                .collect(Collectors.toCollection(() -> new ArrayList<String>()));
    }

    public Map<String, Integer> makeMapOf(String spotter)
    {
        return sightings.stream()
                .filter(sighting -> sighting.getSpotter().equals(spotter))
                .collect(Collectors.groupingBy(Sighting::getAnimal,Collectors.summingInt(Sighting::getCount)));
    }

    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        return sightings.stream()
                .filter(sighting -> animal.equals(sighting.getAnimal()))
                .map(sighting -> sighting.getCount())
                .reduce(0, (runningSum, count) -> runningSum + count);
    }
}

