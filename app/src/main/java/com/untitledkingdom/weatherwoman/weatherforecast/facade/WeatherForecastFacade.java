package com.untitledkingdom.weatherwoman.weatherforecast.facade;

import com.untitledkingdom.weatherwoman.weatherforecast.dto.CityWeatherForecastDto;
import com.untitledkingdom.weatherwoman.weatherforecast.service.WeatherService;

import java.util.List;

public class WeatherForecastFacade {

    private final WeatherService weatherService;

    public WeatherForecastFacade(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public double getMinTemperature() {
        return weatherService.getMinTemperature();
    }

    public void getMaxTempAndCity() {
        weatherService.printCitiesAndItsMaxTemp();
    }

    public String getSmallestAverageTemperature() {
        return weatherService.getCityWithTheSmallestAverageDailyTemp();
    }

    public List<CityWeatherForecastDto> getAllForecasts() {
        return weatherService.getFullWeatherForecast();
    }
}
