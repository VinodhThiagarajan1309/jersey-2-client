package com.jerseyclient;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by vthiagarajan on 11/19/17.
 */
public class WeatherClient {

    private final WebTarget endPoint;

    public WeatherClient(Client jersey) throws URISyntaxException {
        this.endPoint = jersey.target("http://api.openweathermap.org");
    }

    public JsonObject getCurrentWeather(String cityWithCountryCode) {
        JsonParser parser = new JsonParser();

        Invocation.Builder request =
            endPoint
            .path("data/2.5/weather")
            .queryParam("q",cityWithCountryCode)
            .queryParam("APPID", "a15dc5154ed56253325131bf5d8bb71c")
            .request(MediaType.APPLICATION_JSON_TYPE);
        Response response = request.get();
        System.out.println(response.getStatus());

        if(response.getStatus() == 200) {
            JsonObject unitProfileObject = parser
                .parse(response.readEntity(String.class))
                .getAsJsonObject();
            return unitProfileObject;
        }

        return null;

    }


}
