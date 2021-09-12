package com.untitledkingdom.weatherwoman.use_cases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityDto {

    private String city;

    @JsonProperty(value = "weather")
    private String weather;

    @JsonProperty(value = "hourly_temp")
    private List<HourlyTemperatureDto> hourly_temp;

    public CityDto() {
    }

    public CityDto(String city, String weather, List<HourlyTemperatureDto> hourly_temp) {
        this.city = city;
        this.weather = weather;
        this.hourly_temp = hourly_temp;
    }

    public double getAverageTemperature() {
        double sumOfTemperatures = 0;

        for (HourlyTemperatureDto hourlyTemp : getHourly_temp()) {
            sumOfTemperatures += hourlyTemp.getTemp();
        }
        return sumOfTemperatures / getHourly_temp().size();
    }

    public double getMinTemperature() {
        double minTemperature = Double.MAX_VALUE;
        for (HourlyTemperatureDto hourlyTemperature : getHourly_temp()) {
            if (hourlyTemperature.getTemp() < minTemperature) {
                minTemperature = hourlyTemperature.getTemp();
            }
        }
        return minTemperature;
    }

    public String getCity() {
        return city;
    }

    public String getWeather() {
        return weather;
    }

    public List<HourlyTemperatureDto> getHourly_temp() {
        return hourly_temp;
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "city='" + city + '\'' +
                ", weather='" + weather + '\'' +
                ", hourly_tmp=" + getHourly_temp() +
                '}';
    }
}
