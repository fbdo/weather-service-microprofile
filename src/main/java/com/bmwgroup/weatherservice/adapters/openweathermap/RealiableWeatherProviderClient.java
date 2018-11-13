package com.bmwgroup.weatherservice.adapters.openweathermap;

import com.bmwgroup.weatherservice.application.WeatherProviderClient;
import com.bmwgroup.weatherservice.application.WeatherProviderForecast;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
@Named("reliable")
public class RealiableWeatherProviderClient implements WeatherProviderClient {

    private static Logger LOG = Logger.getLogger(RealiableWeatherProviderClient.class.getName());

    @Inject @ConfigProperty(name="com.bmwgroup.weatherservice.adapters.openweathermap.OpenWeatherMapRestClient/mp-rest/url")
    private String url;

    @Inject
    @Named("openweathermap")
    private WeatherProviderClient decorated;

    @Override
    @CircuitBreaker
    @Fallback(fallbackMethod = "reliableCurrent")
    public WeatherProviderForecast current(Optional<String> cityName) {
        return decorated.current(cityName);
    }

    public WeatherProviderForecast reliableCurrent(Optional<String> cityName) {
        LOG.fine(String.format("Access to weather service url %s failed, returning reliable response", url));

        return new WeatherProviderForecast(cityName.orElse("Munich"), -273.15, "Unknown");
    }

}
