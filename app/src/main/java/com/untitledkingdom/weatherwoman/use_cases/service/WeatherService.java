package com.untitledkingdom.weatherwoman.use_cases.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.untitledkingdom.weatherwoman.use_cases.dto.CityDto;
import com.untitledkingdom.weatherwoman.use_cases.dto.HourlyTemperatureDto;
import com.untitledkingdom.weatherwoman.use_cases.dto.ListCitiesDto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {

    private List<CityDto> weatherForecast;

    public WeatherService() {
    }

    public void decodeJson(InputStream inputStream) {
        String txtFile = reedFile(inputStream);
        List<CityDto> cities = gsonDecodeJson(txtFile);
        setWeatherForecast(cities);
    }

    public String reedFile(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bufferedBytes = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(bufferedBytes)) != -1) {
                byteArrayOutputStream.write(bufferedBytes, 0, len);
            }
            byteArrayOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.getCause();
        }
        return byteArrayOutputStream.toString();
    }

    private List<CityDto> gsonDecodeJson(String jsonToDecode) {
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<CityDto>>(){}.getType();
        ArrayList<CityDto> citiesList = gson.fromJson(jsonToDecode, userListType);
        return citiesList;
    }

    public void setWeatherForecast(List<CityDto> weatherForecast) {
        this.weatherForecast = weatherForecast;
    }

    public double getMinTemperature() {
        double minTemp = Double.MAX_VALUE;
        for (CityDto city : weatherForecast) {
            if (city.getMinTemperature() < minTemp) {
                minTemp = city.getMinTemperature();
            }
        }
        return minTemp;
    }

    public String getCitiesAndItsMaxTemp() {

        String city = "";
        StringBuilder stringBuilder = new StringBuilder();

        for (CityDto cityDto : weatherForecast) {
            city = cityDto.getCity();
            double maxTemperature = cityDto.getHourly_temp().stream()
                    .map(HourlyTemperatureDto::getTemp)
                    .max(Double::compareTo)
                    .orElse(0.0);
            stringBuilder.append(city).append(" : ").append(maxTemperature);
        }
        return stringBuilder.toString();
    }

    public String getCityWithTheSmallestAverageDailyTemp() {
        String city = "";
        double result = Double.MAX_VALUE;

        for (CityDto cityDto : weatherForecast) {
            double averageTemp = cityDto.getAverageTemperature();
            if (averageTemp < result) {
                result = averageTemp;
                city = cityDto.getCity();
            }
        }
        return city + " : " + result;
    }

    public void getFullWeatherForecast() {
         weatherForecast.forEach(System.out::println);
    }
}
