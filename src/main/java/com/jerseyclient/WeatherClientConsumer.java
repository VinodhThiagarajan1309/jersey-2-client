package com.jerseyclient;

import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * Created by vthiagarajan on 11/19/17.
 */
public class WeatherClientConsumer {

    public static void main(String[] args) throws URISyntaxException {
        Client client = ClientBuilder.newClient();
        WeatherClient wc = new WeatherClient(client);
        String response = wc.getCurrentWeather("London,uk").toString();
        System.out.println(response);

    }
}
