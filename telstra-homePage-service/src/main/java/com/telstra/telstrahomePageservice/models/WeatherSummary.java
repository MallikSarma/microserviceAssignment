package com.telstra.telstrahomePageservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class WeatherSummary {

    private  String country;

    private String city;

    private String zipCode;

    private  String Precipitation;

    private  String Humidity;

    private  String Wind;

    private  String temperature;


}

