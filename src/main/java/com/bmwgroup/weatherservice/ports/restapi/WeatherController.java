package com.bmwgroup.weatherservice.ports.restapi;

import com.bmwgroup.weatherservice.application.WeatherData;
import com.bmwgroup.weatherservice.application.WeatherService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@ApplicationScoped
@Path("/")
public class WeatherController {

    @Inject
    private WeatherService weatherService;

    @GET
    @Path("/current")
    @Produces(MediaType.APPLICATION_JSON)
    public WeatherData current(@QueryParam("city") @DefaultValue("Munich") String cityName) {
        return weatherService.current(Optional.of(cityName));
    }
}
