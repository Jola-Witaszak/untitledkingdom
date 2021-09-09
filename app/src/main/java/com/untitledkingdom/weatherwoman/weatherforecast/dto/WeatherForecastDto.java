package com.untitledkingdom.weatherwoman.weatherforecast.dto;

import java.util.ArrayList;
import java.util.List;

public class WeatherForecastDto {

    private final List<CityWeatherForecastDto> forecast = new ArrayList<>();

    public WeatherForecastDto() {
    }

    public List<CityWeatherForecastDto> getForecast() {
        return forecast;
    }
}
