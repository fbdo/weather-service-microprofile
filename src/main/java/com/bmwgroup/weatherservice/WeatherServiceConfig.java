package com.bmwgroup.weatherservice;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/")
public class WeatherServiceConfig extends Application {
}
