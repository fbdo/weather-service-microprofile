package com.bmwgroup.weatherservice.application;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@ApplicationScoped
public class WeatherService {

    @Inject
    @Named("reliable")
    private WeatherProviderClient weatherProviderClient;

    public WeatherData current(Optional<String> cityName) {
        WeatherProviderForecast forecast = weatherProviderClient.current(cityName);
        return new WeatherData(forecast.getTemperature(), forecast.getDescription());
    }
}
