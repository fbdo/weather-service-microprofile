package com.bmwgroup.weatherservice.adapters.openweathermap;

import com.bmwgroup.weatherservice.application.WeatherProviderClient;
import com.bmwgroup.weatherservice.application.WeatherProviderForecast;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
@Named("openweathermap")
public class OpenWeatherProviderClient implements WeatherProviderClient {

    private static Logger LOG = Logger.getLogger(OpenWeatherProviderClient.class.getName());

    @Inject
    @ConfigProperty(name="openweathermap.apikey")
    private String apiKey;


    @Inject
    @RestClient
    private OpenWeatherMapRestClient restClient;

    @Override
    public WeatherProviderForecast current(Optional<String> cityName) {
        LOG.fine("Requesting remote service");

        OpenWeatherMapResponse resp = restClient.getCurrentByCity(apiKey, cityName.orElse("Munich"), "metric");

        if (resp.getCities().length > 0) {
            return new WeatherProviderForecast(resp.getCities()[0].getName(), resp.getCities()[0].getMainForecast().getTemperature(), resp.getCities()[0].getWeather()[0].getDescription());
        }
        throw new IllegalArgumentException(cityName.get());
    }
}
