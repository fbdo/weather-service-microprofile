package com.bmwgroup.weatherservice.adapters.openweathermap;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RegisterRestClient
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OpenWeatherMapRestClient {

    @GET
    @Path("/find")
    OpenWeatherMapResponse getCurrentByCity(
            @QueryParam("appid") String appid,
            @QueryParam("q") @DefaultValue("Munich") String city,
            @QueryParam("units") @DefaultValue("metrics") String unit
            );
}
