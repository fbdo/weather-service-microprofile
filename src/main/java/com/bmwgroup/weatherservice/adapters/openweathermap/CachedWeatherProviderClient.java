package com.bmwgroup.weatherservice.adapters.openweathermap;

import com.bmwgroup.weatherservice.application.WeatherProviderClient;
import com.bmwgroup.weatherservice.application.WeatherProviderForecast;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ApplicationScoped
@Named("cached")
public class CachedWeatherProviderClient implements WeatherProviderClient {

    @Inject
    @Named("reliable")
    private WeatherProviderClient decorated;

    private ConcurrentMap< Optional<String>, WeatherProviderForecast > weatherCache = new ConcurrentHashMap<>();


    @Override
    public WeatherProviderForecast current(Optional<String> cityName) {
        return weatherCache.computeIfAbsent(cityName, key -> decorated.current(key));
    }
}
