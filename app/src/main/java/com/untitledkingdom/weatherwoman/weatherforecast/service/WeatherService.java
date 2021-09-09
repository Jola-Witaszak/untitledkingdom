package com.untitledkingdom.weatherwoman.weatherforecast.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.untitledkingdom.weatherwoman.weatherforecast.dto.CityWeatherForecastDto;
import com.untitledkingdom.weatherwoman.weatherforecast.dto.HourlyTemperatureDto;
import com.untitledkingdom.weatherwoman.weatherforecast.dto.WeatherForecastDto;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class WeatherService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final List<CityWeatherForecastDto> weatherForecast = decodeJson();

    public WeatherService() throws IOException {
    }

    private List<CityWeatherForecastDto> decodeJson () throws IOException {

        WeatherForecastDto decodedJson = objectMapper.readValue(
                new File("C:\\Development\\UntitledKingdom\\Weatherwoman\\app\\src\\main\\res"),
                WeatherForecastDto.class);

        return decodedJson.getForecast();
    }

    public double getMinTemperature() {
        return weatherForecast.stream()
                .flatMap(cityWeather -> cityWeather.getTemperatures().stream())
                .map(HourlyTemperatureDto::getTemp)
                .min(Double::compareTo)
                .orElse(0.0);
    }

    public void printCitiesAndItsMaxTemp() {

        for (CityWeatherForecastDto cityWeatherForecastDto : weatherForecast) {
            String city = cityWeatherForecastDto.getCity();
            double maxTemperature = cityWeatherForecastDto.getTemperatures().stream()
                    .map(HourlyTemperatureDto::getTemp)
                    .max(Double::compareTo)
                    .orElse(0.0);
            System.out.println(city + " : " + maxTemperature);
        }
    }

    public String getCityWithTheSmallestAverageDailyTemp() {
        String city = "";
        double result = Double.MAX_VALUE;

        for (CityWeatherForecastDto cityWeatherForecastDto : weatherForecast) {
            double averageTemp = getAverageTemperature();
            if (averageTemp < result) {
                result = averageTemp;
                city = cityWeatherForecastDto.getCity();
            }
        }
        return city;
    }

    public double getAverageTemperature() {
        double sum = weatherForecast.stream()
                .flatMap(cityWeatherForecastDto -> cityWeatherForecastDto.getTemperatures().stream())
                .map(HourlyTemperatureDto::getTemp)
                .reduce(0.0, Double::sum);

        long listSize = weatherForecast.stream()
                .map(CityWeatherForecastDto::getTemperatures)
                .count();

        return sum / listSize;
    }

    public List<CityWeatherForecastDto> getFullWeatherForecast() {
        return weatherForecast;
    }
}
