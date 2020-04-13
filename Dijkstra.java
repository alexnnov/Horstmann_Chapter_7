package com.horstmann_chapter_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra
{
    public static void computePaths(City source)
    {
        source.weight = 0;
        PriorityQueue<City> cityQueue = new PriorityQueue<City>();
        cityQueue.add(source);

        while (!cityQueue.isEmpty()) {
            City u = cityQueue.poll();


            for (Neighbour n : u.neighbours)
            {
                City c = n.city;
                double distance = n.distance;
                double distanceThroughU = u.weight + distance;
                if (distanceThroughU < c.weight) {
                    cityQueue.remove(c);

                    c.weight = distanceThroughU ;
                    c.previous = u;
                    cityQueue.add(c);
                }
            }
        }
    }

    public static List<City> getShortestPathTo(City target)
    {
        List<City> path = new ArrayList<City>();
        for (City city = target; city != null; city = city.previous)
            path.add(city);

        Collections.reverse(path);
        return path;
    }


}