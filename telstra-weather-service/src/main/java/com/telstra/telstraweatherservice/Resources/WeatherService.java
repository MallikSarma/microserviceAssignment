package com.telstra.telstraweatherservice.Resources;

import com.telstra.telstraweatherservice.model.WeatherSummary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherService {

    @RequestMapping("/{zipCode}")
    public WeatherSummary getWeatherDetails(@PathVariable("zipCode") String zipCode){

        return getWeatherDetails().stream().filter(weatherSummary -> weatherSummary.getZipCode().
                equalsIgnoreCase(zipCode)).findAny()
                .orElse(new WeatherSummary("","","","","", "",""));


    }

    public List<WeatherSummary> getWeatherDetails(){

        return Arrays.asList(new WeatherSummary("IND","HYDERABAD","500082","2%","86", "10","28°C"),
                new WeatherSummary("AUS","PERTH","6000","4%","56", "9","29°C"),
                new WeatherSummary("US","COLOMBUS","43004","6%","66", "6","4°C"),
                new WeatherSummary("UK","LONDON","EC1A","3%","59", "8","6°C"));

    }

}
