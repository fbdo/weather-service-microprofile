package com.bmwgroup.weatherservice.application;

public class WeatherProviderForecast {

    private String cityName;
    private double temperature;
    private String description;

    public WeatherProviderForecast(String cityName, double temp, String description) {
        this.cityName = cityName;
        this.temperature = temp;
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
