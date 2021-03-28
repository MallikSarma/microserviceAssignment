package com.telstra.telstrahomePageservice.resources;

import com.telstra.telstrahomePageservice.models.HomePageDetails;
import com.telstra.telstrahomePageservice.models.StockDetails;
import com.telstra.telstrahomePageservice.models.WeatherSummary;
import com.telstra.telstrahomePageservice.services.StockService;
import com.telstra.telstrahomePageservice.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Telstra/homePage")
public class HomePageResources {

   @Autowired
    RestTemplate restTemplate;

   @Autowired
   StockService stockService;

   @Autowired
   WeatherService weatherService;

    @GetMapping("/{zipCode}")
    public HomePageDetails getHomePageDetails(@PathVariable("zipCode") String zipCode){
        HomePageDetails s = new HomePageDetails();
        StockDetails stock = stockService.getStockDetails();
        WeatherSummary weather = weatherService.getWeatherDetails(zipCode);
        s.setStockDetails(stock);
        s.setWeatherSummary(weather);
        return s;
    }



}
