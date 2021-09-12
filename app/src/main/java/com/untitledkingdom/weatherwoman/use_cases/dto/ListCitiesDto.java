package com.untitledkingdom.weatherwoman.use_cases.dto;

import java.util.ArrayList;
import java.util.List;

public class ListCitiesDto {

    private final List<CityDto> forecast = new ArrayList<>();

    public ListCitiesDto() {
    }

    public List<CityDto> getForecast() {
        return forecast;
    }
}
