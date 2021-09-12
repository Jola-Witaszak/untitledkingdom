package com.untitledkingdom.weatherwoman.use_cases.facade;

import com.untitledkingdom.weatherwoman.use_cases.dto.CityDto;
import com.untitledkingdom.weatherwoman.use_cases.service.WeatherService;

import java.io.InputStream;
import java.util.List;

public class WeatherForecastFacade {

    private final WeatherService weatherService = new WeatherService();

    public WeatherForecastFacade() {

    }

    public void decodeJson(InputStream inputStream) {
         weatherService.decodeJson(inputStream);
    }

    public String reedFile(InputStream inputStream) {
        return weatherService.reedFile(inputStream);
    }

    public double getMinTemperature() {
        return weatherService.getMinTemperature();
    }

    public String getMaxTempAndCity() {
        return weatherService.getCitiesAndItsMaxTemp();
    }

    public String getSmallestAverageTemperature() {
        return weatherService.getCityWithTheSmallestAverageDailyTemp();
    }

    public void getFullForecast() {
         weatherService.getFullWeatherForecast();
    }
}
