package com.telstra.telstrahomePageservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.telstra.telstrahomePageservice.models.WeatherSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackWeatherDetails",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                            , value = "2000"),
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                            , value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",
                            value="5"
                    ),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage"
                            , value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds"
                            , value = "5000")
            }
    )
    public WeatherSummary getWeatherDetails(String zipCode) {
        return restTemplate.getForObject("http://WEATHER-SERVICE/weather/" + zipCode, WeatherSummary.class);
    }

    public WeatherSummary getFallbackWeatherDetails(@PathVariable("zipCode") String zipCode){

        return new WeatherSummary("Weather details not avaiable", "",
                "","","","","");

    }
}
