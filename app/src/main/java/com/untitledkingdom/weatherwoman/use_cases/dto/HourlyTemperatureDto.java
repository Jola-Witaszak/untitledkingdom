package com.untitledkingdom.weatherwoman.use_cases.dto;

public class HourlyTemperatureDto {

    private double temp;
    private int hour;

    public HourlyTemperatureDto() {
    }

    public HourlyTemperatureDto(double temp, int hour) {
        this.temp = temp;
        this.hour = hour;
    }

    public double getTemp() {
        return temp;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "HourlyTemperature{" +
                "temp=" + temp +
                ", hour=" + hour +
                '}';
    }
}
