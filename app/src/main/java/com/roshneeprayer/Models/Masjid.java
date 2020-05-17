package com.roshneeprayer.Models;

public class Masjid {
    String name,distance;
    int imageResourse;

    public Masjid(String name, String distance, int imageResourse) {
        this.name = name;
        this.distance = distance;
        this.imageResourse = imageResourse;
    }

    public String getName() {
        return name;
    }
}
