package com.bmwgroup.weatherservice.adapters.openweathermap;

import javax.json.bind.annotation.JsonbProperty;

public class CityWeatherForecast {
    private String name;

    @JsonbProperty("main")
    private CityWeatherMainForecast mainForecast;

    @JsonbProperty("weather")
    private WeatherDetails[] weather;

    public String getName() {
        return name;
    }

    public CityWeatherMainForecast getMainForecast() {
        return mainForecast;
    }

    public WeatherDetails[] getWeather() {
        return weather;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMainForecast(CityWeatherMainForecast mainForecast) {
        this.mainForecast = mainForecast;
    }

    public void setWeather(WeatherDetails[] weather) {
        this.weather = weather;
    }
}
