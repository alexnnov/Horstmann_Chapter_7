package com.horstmann_chapter_7;

import java.util.ArrayList;

public class City implements Comparable<City>{
    String name;
    double weight = Double.POSITIVE_INFINITY;
    public City previous;
    public String toString(){
        return name;
    }
    Neighbour[] neighbours;
    City(String name){
        this.name=name;
    }

    public int compareTo(City other){
        return Double.compare(weight,other.weight);
    }
}
