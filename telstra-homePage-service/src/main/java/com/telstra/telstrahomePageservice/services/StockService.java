package com.telstra.telstrahomePageservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.telstra.telstrahomePageservice.models.StockDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class StockService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackStockDetails",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
            , value = "2000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    , value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="5"
                    ),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage"
                    , value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds"
                    , value = "5000")
    })
    public StockDetails getStockDetails() {
        return restTemplate.getForObject("http://STOCK-SERVICE/stock/TLS.AX", StockDetails.class);
    }

    public StockDetails getFallbackStockDetails(){

       return new StockDetails("No Stock Available", new BigDecimal(0.0),
               new BigDecimal(0.0), "AUD", new BigDecimal(0.0));

    }
}