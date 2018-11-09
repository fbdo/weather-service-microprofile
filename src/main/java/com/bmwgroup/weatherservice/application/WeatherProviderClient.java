package com.bmwgroup.weatherservice.application;

import java.util.Optional;

public interface WeatherProviderClient {

    WeatherProviderForecast current(Optional<String> cityName);
}
