package com.aveiro.workshop;


import java.util.Date;

public class WeatherInfo {

    private Date date;
    private int average, max, min;

    public WeatherInfo(Date date, int average, int max, int min) {
        this.date = date;
        this.average = average;
        this.max = max;
        this.min = min;
    }

    public Date getDate() {
        return date;
    }

    public int getAverage() {
        return average;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
