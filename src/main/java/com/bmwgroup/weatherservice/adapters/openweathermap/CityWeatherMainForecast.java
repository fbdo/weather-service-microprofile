package com.bmwgroup.weatherservice.adapters.openweathermap;

import javax.json.bind.annotation.JsonbProperty;

public class CityWeatherMainForecast {
    @JsonbProperty("temp")
    private double temperature;

    @JsonbProperty("temp_min")
    private double minTemperature;

    @JsonbProperty("temp_max")
    private double maxTemperature;

    public double getTemperature() {
        return temperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
