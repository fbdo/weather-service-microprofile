package com.bmwgroup.weatherservice.adapters.openweathermap;

import javax.json.bind.annotation.JsonbProperty;

public class OpenWeatherMapResponse {

    @JsonbProperty("list")
    private CityWeatherForecast[] cities;

    public CityWeatherForecast[] getCities() {
        return cities;
    }

    public void setCities(CityWeatherForecast[] cities) {
        this.cities = cities;
    }
}
