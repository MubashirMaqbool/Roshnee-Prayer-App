package com.roshneeprayer.Models;

public class News {
    public News(String heading, String date, String description) {
        this.heading = heading;
        this.date = date;
        this.description = description;
    }

    String heading,date,description;

    public String getHeading() {
        return heading;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
