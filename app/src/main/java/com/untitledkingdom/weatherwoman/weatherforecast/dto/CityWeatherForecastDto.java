package com.untitledkingdom.weatherwoman.weatherforecast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CityWeatherForecastDto {

    private String city;

    @JsonProperty(value = "weather")
    private String description;

    @JsonProperty(value = "hourly_temp")
    private List<HourlyTemperatureDto> temperatures;

    public CityWeatherForecastDto() {
    }

    public CityWeatherForecastDto(String city, String description, List<HourlyTemperatureDto> temperatures) {
        this.city = city;
        this.description = description;
        this.temperatures = temperatures;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public List<HourlyTemperatureDto> getTemperatures() {
        return temperatures;
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "city='" + city + '\'' +
                ", weather='" + description + '\'' +
                ", hourly_tmp=" + getTemperatures() +
                '}';
    }
}
